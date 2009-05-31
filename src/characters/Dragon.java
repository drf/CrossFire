package characters;

import items.ItemGenerator;
import gameChart.Box;
import gameChart.BoxBusyException;
import globals.Entity;

public class Dragon extends Monster {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3947223500999381060L;

	public Dragon() {
		super(50, 80, 30, 0, 5, 60);
	}
	
	public void boxChanged(Box oldBox, Box newBox) {
	}

	
	public int getDamageReduction() {
		return 5;
	}

	
	public void onDeath() {
		// Drop an item as a reward
		try {
			getBox().getChart().place((Entity)ItemGenerator.generateCasualEquipable(), getBox());
		} catch (BoxBusyException e) {
			
		}
	}

	
	public int getMeleeAttackBonus() {
		return 5;
	}

}
