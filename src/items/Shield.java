package items;

import gameLogic.Equipable;

/**
 * Shield as defined in the game specifics
 * 
 * @author drf
 *
 */
public class Shield extends Item implements Equipable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3329552295419351743L;

	/**
	 * Create a new shield
	 */
	public Shield() {
		super(0, 0, 0, -10, 0, 0, 0, 0, 0, 0, 10);
	}

}
