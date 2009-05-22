package gameLogic;


import java.util.Random;

public class CombatHandler {
	
	public enum AttackType {
		Melee,
		Ranged,
		Magic
	}
	
	public CombatHandler() {
		
	}
	
	public static int meleeAttack(CanAttack from, Attackable to) {
		// Compute damage according to specifics
		Random r = new Random();
		double multiplier = 0.5;
		int damage;
		if (to.getStrength() > 70) {
			multiplier = 0.3;
		}
		
		damage = (int)(from.getStrength() * multiplier);
		
		// Now add some luck factor
		int luck = from.getLuck() - to.getLuck();
		
		if (luck < 0) {
			int t = (int)(r.nextInt(-luck) * 0.2);
			damage -= t;
		} else if (luck > 0) {
			int t = (int)(r.nextInt(luck) * 0.2);
			damage += t;
		}
		
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

}
