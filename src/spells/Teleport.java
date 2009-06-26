package spells;

import gameChart.Box;
import gameChart.BoxBusyException;
import gameLogic.Attackable;
import gameLogic.CanMagicAttack;
import globals.Entity;

public class Teleport extends Spell {

	public Teleport() {
		super(40, 100, 0, "Teleport", "Ammazzi laggente");
		setDealsDamage(false);
	}

	@Override
	public int computeDamage(CanMagicAttack caster, Attackable target,
			int rangeLevel) {
		try {
		try {
			((Entity)caster).getBox().getChart().place((Entity)caster, (Box)(((Entity)target).getBox().getAdjacentBoxes().toArray()[0]));
		} catch (BoxBusyException e) {
			try {
				((Entity)caster).getBox().getChart().place((Entity)caster, (Box)(((Entity)target).getBox().getAdjacentBoxes().toArray()[1]));
			} catch (BoxBusyException e1) {
				try {
					((Entity)caster).getBox().getChart().place((Entity)caster, (Box)(((Entity)target).getBox().getAdjacentBoxes().toArray()[2]));
				} catch (BoxBusyException e2) {
					try {
						((Entity)caster).getBox().getChart().place((Entity)caster, (Box)(((Entity)target).getBox().getAdjacentBoxes().toArray()[3]));
					} catch (BoxBusyException e3) {
						return -1;
					}
				}
			}
		}
		} catch (Exception e) {
			return -1;
		}
		return 0;
	}

}
