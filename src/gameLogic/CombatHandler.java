package gameLogic;


import globals.Pair;

import java.util.EnumSet;
import java.util.Random;

public class CombatHandler {
	
	public enum AttackType {
		Melee,
		Ranged,
		Magic
	}
	
	public CombatHandler() {
		
	}
	
	private static int genericAttack(CanAttack from, Attackable to, int damage)
	{
		
		// Now add some luck factor
		damage += computeLuckFactor(from.getLuck() - to.getLuck(), 0.2);
		damage -= to.getDamageReduction();
		
		if (damage < 0) {
			damage = 0;
		}
		
		if(to.getHp() > damage)
		{
			to.setHp(to.getHp() - damage);
		}else {
			to.setHp(0);
			to.onDeath();
		}
		
		return damage;
	}
	
	public static Pair<Integer> meleeAttack(CanMeleeAttack from, Attackable to) {
		int damage, counterdamage = 0;
		
		// Compute damage according to specifics
		damage = (int)(from.getStrength() * 0.5) +from.getMeleeAttackBonus();
		damage = genericAttack(from, to, damage);
		
		
		// Can we counter?
		if (to.getStrength() > 70 && to.getHp() > 0 && from instanceof Attackable && to instanceof CanMeleeAttack) {
			System.out.println("Condition");
			
			Attackable tmpto = (Attackable)from;
			from = (CanMeleeAttack)to;
			to = tmpto;
			
			counterdamage = (int)(from.getStrength() * 0.3) + from.getMeleeAttackBonus();
			counterdamage = genericAttack(from, to, counterdamage);
		}
		
		return new Pair<Integer>(damage, counterdamage);
		
	}
	
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
		int damage = (int)(from.getStrength() * 0.3) + from.getRangedAttackBonus();
		damage = genericAttack(from, to, damage);
		
		return damage;
	}
	
	public static int magicAttack(CanMagicAttack from, Attackable to) {
		int damage = (int)(from.getIntelligence() * 0.2 + from.getMagicSkill() * 0.5) + from.getMagicDamageBonus();
		damage = genericAttack(from, to, damage);
						
		return damage;
	}
	
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
	
	private static int computeLuckFactor(int luck, double multiplier) {
		Random r = new Random();
		
		if (luck < 0) {
			int t = (int)(r.nextInt(-luck) * 0.2);
			return -t;
		} else if (luck > 0) {
			int t = (int)(r.nextInt(luck) * 0.2);
			return t;
		} else {
			return 0;
		}
	}

}
