package spells;

import java.util.Random;

import characters.Fighter;

import gameLogic.Attackable;
import gameLogic.CanMagicAttack;
import gameLogic.Game;
import globals.PlayableEntity;

public class DarkGaze extends Spell {

	public DarkGaze() {
		super(100, 5, 0, "Dark Gaze", "Imprisons an enemy's soul, putting him under your control. Might fail");
		setDealsDamage(false);
	}
	
	@Override
	public int computeDamage(CanMagicAttack caster, Attackable target,
			int rangeLevel) {
		Random r = new Random();
		if (target instanceof Fighter) {
			int possibility = 50 + (caster.getIntelligence() - ((Fighter)target).getIntelligence()) * 2;
			if (r.nextInt(101) <= possibility) {
				Game.getInstance().assignEntity(((PlayableEntity)caster).getPlayer(), (PlayableEntity)target);
				return 0;
			} else {
				return -1;
			}
		} else {
			Game.getInstance().assignEntity(((PlayableEntity)caster).getPlayer(), (PlayableEntity)target);
			return 0;
		}
	}
	
	@Override
	public boolean fulfillsSpecialRequirements(CanMagicAttack caster,
			Attackable target) {
		return target instanceof PlayableEntity && caster instanceof PlayableEntity;
	}

}
