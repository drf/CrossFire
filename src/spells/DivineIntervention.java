package spells;

import gameLogic.Attackable;
import gameLogic.CanMagicAttack;

public class DivineIntervention extends Spell {

	public DivineIntervention() {
		super(40, 50, 1, "Divine Intervention", "Heals completely a target and all nearby targets");
	}
	
	@Override
	public int computeDamage(CanMagicAttack caster, Attackable target,
			int rangeLevel) {
		return -(int)(100 - target.getHp());
	}

}
