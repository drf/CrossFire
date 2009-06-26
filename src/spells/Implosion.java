package spells;

import gameLogic.Attackable;
import gameLogic.CanMagicAttack;

public class Implosion extends Spell {

	public Implosion() {
		super(30, 70, 0, "Implosion", "Deals serious damage to a target");
	}
	
	@Override
	public int computeDamage(CanMagicAttack caster, Attackable target,
			int rangeLevel) {
		return (int)((caster.getIntelligence() * 0.2 + caster.getMagicSkill() * 0.5) 
			         + caster.getMagicDamageBonus());
	}

}
