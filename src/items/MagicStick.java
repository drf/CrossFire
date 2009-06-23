package items;

import gameLogic.Equipable;
import globals.BaseAttributes;

/**
 * Magic stick as defined in the game specifics
 * 
 * @author drf
 *
 */
public class MagicStick extends Item implements Equipable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4010072967149254580L;

	/**
	 * Create a new magic stick
	 */
	public MagicStick() {
		super(0, 0, 0, 0, 0, 0, 0, +10, 0, 0, 0);
		BaseAttributes minReq = new BaseAttributes();
		minReq.setMagicSkill(70);
		setMinimumRequirements(minReq);
		setName("Magic Stick");
	}

}
