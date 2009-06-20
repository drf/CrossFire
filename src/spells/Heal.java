package spells;

import gameLogic.Attackable;
import gameLogic.CanMagicAttack;

public class Heal extends Spell {

	public Heal() {
		super(15, 5, 0, "Heal", "Heals a target");
	}
	
	@Override
	public int computeDamage(CanMagicAttack caster, Attackable target,
			int rangeLevel) {
		return -(int)(caster.getIntelligence() * 0.4 + caster.getMagicSkill() * 0.3);
	}

}
