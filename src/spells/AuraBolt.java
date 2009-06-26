package spells;

import gameLogic.Attackable;
import gameLogic.CanMagicAttack;

public class AuraBolt extends Spell {

	public AuraBolt() {
		super(15, 1, 0, "Aura Bolt", "A strong flash of energy hits a single nearby enemy");
	}

	@Override
	public int computeDamage(CanMagicAttack caster, Attackable target, int rangeLevel) {
		return (int)(caster.getIntelligence() * 0.35 + caster.getMagicSkill() * 0.3 
				     - target.getDexterity() * 0.1 + caster.getMagicDamageBonus());
	}

}
