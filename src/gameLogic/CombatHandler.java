package gameLogic;


import globals.Pair;

import java.util.Random;

public class CombatHandler {
	
	public enum AttackType {
		Melee,
		Ranged,
		Magic
	}
	
	public CombatHandler() {
		
	}
	
	public static Pair<Integer> meleeAttack(CanMeleeAttack from, Attackable to) {
		// Compute damage according to specifics
		double multiplier = 0.5;
		int damage, counterdamage = 0;
		
		damage = (int)(from.getStrength() * multiplier);
		
		// Now add some luck factor
		damage += computeLuckFactor(from.getLuck() - to.getLuck(), 0.2);
		
		if (damage < 0) {
			damage = 0;
		}
		
		int newhp = to.getHp() - damage;
		if (newhp < 0) {
			newhp = 0;
		}
		
		to.setHp(newhp);		
		
		if (to.getStrength() > 70 && to.getHp() > 0 && from instanceof Attackable && to instanceof CanMeleeAttack) {
			System.out.println("Condition");
			// Ok, we can counter
			multiplier = 0.3;
			
			Attackable tmpto = (Attackable)from;
			from = (CanMeleeAttack)to;
			to = tmpto;
			
			counterdamage = (int)(from.getStrength() * multiplier);
			
			// Now add some luck factor
			counterdamage += computeLuckFactor(from.getLuck() - to.getLuck(), 0.2);
			
			if (counterdamage < 0) {
				counterdamage = 0;
			}
			
			newhp = to.getHp() - counterdamage;
			if (newhp < 0) {
				newhp = 0;
			}
			
			to.setHp(newhp);
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
		
		int damage = (int)(from.getStrength() * 0.3);
		
		// Now add some luck factor
		damage += computeLuckFactor(from.getLuck() - to.getLuck(), 0.2);
		
		if (damage < 0) {
			damage = 0;
		}
		
		int newhp = to.getHp() - damage;
		if (newhp < 0) {
			newhp = 0;
		}
		
		to.setHp(newhp);
		
		return damage;
	}
	
	public static int magicAttack(CanMagicAttack from, Attackable to) {
		int damage = (int)(from.getIntelligence() * 0.2 + from.getMagicSkill() * 0.5);
		
		// Now add some luck factor
		damage += computeLuckFactor(from.getLuck() - to.getLuck(), 0.2);
		
		if (damage < 0) {
			damage = 0;
		}
		
		int newhp = to.getHp() - damage;
		
		if (newhp < 0) {
			newhp = 0;
		}
		
		to.setHp(newhp);
		
		return damage;
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
