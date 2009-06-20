package spells;

import gameLogic.Attackable;
import gameLogic.CanMagicAttack;

public class Implosion extends Spell {

	public Implosion() {
		super(25, 70, 0, "Implosion", "Deals serious damage to a target");
	}
	
	@Override
	public int computeDamage(CanMagicAttack caster, Attackable target,
			int rangeLevel) {
		return (int)((caster.getIntelligence() * 0.6 + caster.getMagicSkill() * 0.8) 
			         + caster.getMagicDamageBonus());
	}

}
