package spells;

import characters.Fighter;
import gameLogic.Attackable;
import gameLogic.CanMagicAttack;
import globals.PlayableEntity;

public class DarkGaze extends Spell {

	public DarkGaze() {
		super(100, 5, 0, "Dark Gaze", "Imprisons an enemy's soul, putting him under your control. Might fail");
		setDealsDamage(false);
	}
	
	@Override
	public int computeDamage(CanMagicAttack caster, Attackable target,
			int rangeLevel) {
		((PlayableEntity)target).setPlayer(((PlayableEntity)caster).getPlayer());
		return 0;
	}
	
	@Override
	public boolean fulfillsSpecialRequirements(CanMagicAttack caster,
			Attackable target) {
		return target instanceof PlayableEntity && caster instanceof PlayableEntity;
	}

}
