package characters;

import gameChart.Box;

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
		
	}

	
	public int getMeleeAttackBonus() {
		return 5;
	}

}
