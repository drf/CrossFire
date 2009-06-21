package spells;

import gameLogic.Attackable;
import gameLogic.CanMagicAttack;

public class AuraBolt extends Spell {

	public AuraBolt() {
		super(10, 1, 0, "Aura Bolt", "A flash of energy hits a single nearby enemy");
	}

	@Override
	public int computeDamage(CanMagicAttack caster, Attackable target, int rangeLevel) {
		return (int)(caster.getIntelligence() * 0.8 + caster.getMagicSkill() * 0.6 
				     - target.getDexterity() * 0.05 + caster.getMagicDamageBonus());
	}

}
