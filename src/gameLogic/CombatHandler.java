package gameLogic;


import gameChart.Box;
import globals.Entity;
import globals.Pair;

import java.util.Dictionary;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import spells.Spell;
import sun.security.action.GetBooleanAction;

/**
 * <b>CombatHandler</b> is a container of static functions that handle a multitude
 * of attacks between various objects. 
 * <p>
 * In here, it can be appreciated how much flexible the interface
 * approach actually is: each method accepts an interface as a parameter, so that
 * the combat phase is completely abstracted from the type of instance of the object.
 * <p>
 * This means, for example, that we can add another fighting entity just by coding its
 * class, and without modifying any of the internals. 
 * 
 * @author drf
 *
 */
public class CombatHandler {
	
	public enum AttackType {
		Melee,
		Ranged,
		Magic
	}
	
	/**
	 * This function is internal to {@link CombatHandler}, and it's used to compute
	 * and apply the final damage to a specific object.
	 * 
	 * @param from the {@link CanAttack} dealing damage
	 * @param to the {@link Attackable} receiving damage
	 * @param damage the amount of damage, without luck and damage reduction modifiers 
	 * @return the final damage dealt
	 */
	private static int genericAttack(CanAttack from, Attackable to, int damage)
	{
		
		// Now add some luck factor
		damage += computeLuckFactor(from.getLuck() - to.getLuck(), 0.2);
		damage -= to.getDamageReduction();
		
		if (damage < 0) {
			damage = 0;
		}
		
		if (to.getHp() > damage) {
			to.setHp(to.getHp() - damage);
		} else {
			to.setHp(0);
			to.onDeath();
		}
		
		return damage;
	}
	
	/**
	 * Performs a melee attack. This function will take care of computing the damage,
	 * based on specifics and on a luck+random factor, and deal the damage. Since the
	 * specifics say that there is a possibility to counter attack, this function also
	 * handles the possible counter damage.
	 * 
	 * @param from the {@link CanMeleeAttack} attempting the attack
	 * @param to the {@link Attackable} being attacked
	 * @return a {@link Pair} containing the dealt damage as the first member, and the
	 * counter damage as the second member
	 */
	public static Pair<Integer> meleeAttack(CanMeleeAttack from, Attackable to) {
		int damage, counterdamage = 0;
		
		// Compute damage according to specifics
		damage = (int)(from.getStrength() * 0.5) +from.getMeleeDamageBonus();
		damage = genericAttack(from, to, damage);
		
		
		// Can we counter?
		if (to.getStrength() > 70 && to.getHp() > 0 && from instanceof Attackable && to instanceof CanMeleeAttack) {
			System.out.println("Condition");
			
			Attackable tmpto = (Attackable)from;
			from = (CanMeleeAttack)to;
			to = tmpto;
			
			counterdamage = (int)(from.getStrength() * 0.3) + from.getMeleeDamageBonus();
			counterdamage = genericAttack(from, to, counterdamage);
		}
		
		return new Pair<Integer>(damage, counterdamage);
		
	}
	
	/**
	 * Performs a ranged attack. This function will take care of computing the damage,
	 * based on specifics and on a luck+random factor, and deal the damage.
	 * <p>
	 * Please note that this function doesn't take care of checking the
	 * dynamic requirements for the ranged attack, you should check this before using
	 * CanPerformAttack()
	 * 
	 * @param from the {@link CanRangedAttack} attempting the attack
	 * @param to the {@link Attackable} being attacked
	 * @return the dealt damage, -1 if the attack got evaded
	 * 
	 */
	public static int rangedAttack(CanRangedAttack from, Attackable to) {
		// First of all let's check if the attack can be evaded
		if (to.getDexterity() > from.getDexterity()) {
			Random r = new Random();
			int possibility = (to.getDexterity() - from.getDexterity()) * 2;
			
			if (possibility >= 100) {
				return -1;
			}
			
			// Lucky factor
			possibility += computeLuckFactor(to.getLuck() - from.getLuck(), 2);
						
			// Let's randomly see if the target will evade the attack.
			// Obviously, the randomized is balanced upon the difference of attributes
			if (possibility > 0) {
				if (r.nextInt(100) <= possibility) {
					return -1;
				}
			}
		}
		
		// If we got here, it means that the attack will actually be performed
		int damage = (int)(from.getStrength() * 0.3) + from.getRangedDamageBonus();
		damage = genericAttack(from, to, damage);
		
		return damage;
	}
	
	/**
	 * Performs a magic attack. This function will take care of computing the damage,
	 * based on specifics and on a luck+random factor, and deal the damage.
	 * <p>
	 * Please note that this function doesn't take care of checking the
	 * dynamic requirements for the magic attack, you should check this before using
	 * CanPerformAttack()
	 * 
	 * @param from the {@link CanMagicAttack} attempting the attack
	 * @param to the {@link Attackable} being attacked
	 * @return the dealt damage
	 * 
	 */
	public static Map<Attackable, Integer> magicAttack(CanMagicAttack from, Attackable to, Spell spell) {
		Map<Attackable, Integer> retmap = new HashMap<Attackable, Integer>();
				
		retmap.put(to, genericAttack(from, to, spell.computeDamage(from, to, 0)));
		
		// If the spell has a range, let's compute it
		if (spell.getTargetRange() > 0) {
			for (int i = 1; i <= spell.getTargetRange(); i++) {
				for (Box b : ((Entity)to).getBox().getChart().getBoxesAtRange(((Entity)to).getBox(), i)) {
					for (Entity ent : b.getChart().getEntitiesOn(b)) {
						if (ent instanceof Attackable) {
							Attackable target = (Attackable)ent;
							
							retmap.put(target, genericAttack(from, target, spell.computeDamage(from, to, i)));
						}
					}
				}
			}
		}
		
		// Subtract the MPs
		from.setMP(from.getMP() - spell.getCost());
						
		return retmap;
	}
	
	/**
	 * This function returns, based on static and dynamic properties, if a generic
	 * {@link CanAttack} can perform a specific {@link AttackType}.
	 * 
	 * @param attacker the {@link CanAttack} to check capabilities for
	 * @param type the {@link AttackType} to check
	 * @return whether the provided {@link CanAttack} can perform 
	 * the provided {@link AttackType} or not
	 */
	public static boolean canPerformAttack(CanAttack attacker, AttackType type) {
		switch (type) {
		case Magic:
			if (attacker instanceof CanMagicAttack) {
				return ((CanMagicAttack)attacker).canMagicAttack();
			} else {
				return false;
			}
		case Melee:
			return attacker instanceof CanMeleeAttack;
		case Ranged:
			if (attacker instanceof CanRangedAttack) {
				return ((CanRangedAttack)attacker).canRangedAttack();
			} else {
				return false;
			}
		default:
			return false;
		}
	}
	
	/**
	 * This function returns, based on static and dynamic properties, if a generic
	 * {@link CanAttack} can perform a specific {@link AttackType}.
	 * 
	 * @param attacker the {@link CanAttack} to check capabilities for
	 * @param type the {@link AttackType} to check
	 * @return whether the provided {@link CanAttack} can perform 
	 * the provided {@link AttackType} or not
	 */
	public static boolean canCastSpell(CanMagicAttack attacker, Spell type) {
		if (attacker.getAvailableSpells().contains(type) && type.getCost() <= attacker.getMP()) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * This function returns, based on static and dynamic properties, a list of the
	 * attack types a generic {@link CanAttack} is able to perform
	 * 
	 * @param attacker the {@link CanAttack} to check capabilities for
	 * @return a set of the {@link AttackType} the attacker is capable of
	 */
	public static EnumSet<AttackType> attackCapabilities(CanAttack attacker) {
		EnumSet<AttackType> retset = EnumSet.noneOf(AttackType.class);
		
		if (attacker instanceof CanMagicAttack) {
			if(((CanMagicAttack)attacker).canMagicAttack()) {
				retset.add(AttackType.Ranged);
			}
		}
		
		if (attacker instanceof CanMeleeAttack) {
			retset.add(AttackType.Melee);
		}
		
		if (attacker instanceof CanRangedAttack) {
			if (((CanRangedAttack)attacker).canRangedAttack()) {
				retset.add(AttackType.Magic);
			}
		}
		
		return retset;
	}
	
	/**
	 * This function is internal to {@link CombatHandler}, and it computes the damage
	 * difference to apply based on luck and a multiplier 
	 * 
	 * @param luck the difference between the attacker's and the defender's luck
	 * @param multiplier a multiplier to balance the result. 0.2 is a sensible value
	 * @return the difference of damage to apply. Can be negative if the luck influences
	 * positively the defender, in this case the damage gets reduced.
	 */
	private static int computeLuckFactor(int luck, double multiplier) {
		Random r = new Random();
		
		if (luck < 0) {
			int t = (int)(r.nextInt(-luck) * multiplier);
			return -t;
		} else if (luck > 0) {
			int t = (int)(r.nextInt(luck) * multiplier);
			return t;
		} else {
			return 0;
		}
	}

}
