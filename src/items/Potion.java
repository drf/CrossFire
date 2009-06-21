package items;

import gameLogic.Consumable;

/**
 * Potion as defined in the game specifics
 * 
 * @author drf
 *
 */
public class Potion extends Item implements Consumable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4839464455386680310L;

	/**
	 * Create a new potion
	 */
	public Potion() {
		super(0, 0, 0, 0, 0, 0, +10, 0, 0, 0, 0);
	}

}
