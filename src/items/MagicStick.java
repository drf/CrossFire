package items;

import globals.BaseAttributes;

public class MagicStick extends Item implements Equipable {

	public MagicStick() {
		super(0, 0, 0, 0, 0, 0, +10, 0, 0, 0);
		BaseAttributes minReq = new BaseAttributes();
		minReq.setMagicSkill(70);
		setMinimumRequirements(minReq);
	}

}
