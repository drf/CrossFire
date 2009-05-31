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
	
	@Override
	public void boxChanged(Box oldBox, Box newBox) {
	}

	@Override
	public int getDamageReduction() {
		return 5;
	}

	@Override
	public void onDeath() {
		
	}

	@Override
	public int getMeleeAttackBonus() {
		return 5;
	}

}
