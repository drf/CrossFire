package spells;

import java.util.Random;

import gameLogic.Attackable;
import gameLogic.CanMagicAttack;

public class DeathTouch extends Spell {

	public DeathTouch() {
		super(60, 6, 0, "Death Touch", "Attempts to kill a target in a single shot");
		setDealsDamage(false);
	}

	@Override
	public int computeDamage(CanMagicAttack caster, Attackable target,
			int rangeLevel) {
		int possibility = 25;
		possibility += (caster.getIntelligence() + caster.getMagicSkill()) * 0.4 -
					   target.getLuck() * 0.5;
		if (new Random().nextInt(101) < possibility) {
			target.setHp(0);
			target.onDeath();
			return 0;
		} else {
			return -1;
		}
	}

}
