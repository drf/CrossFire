package spells;

import gameLogic.Attackable;
import gameLogic.CanMagicAttack;

public class AuraBolt extends Spell {

	public AuraBolt(int cost, int distanceRange, int targetRange, String name) {
		super(10, 1, 1, "Aura Bolt");
	}

	@Override
	public int computeDamage(CanMagicAttack caster, Attackable target, int rangeLevel) {
		return (int)(caster.getIntelligence() * 0.2 + caster.getMagicSkill() * 0.2 - target.getDexterity() * 0.05);
	}

}
