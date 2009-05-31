package items;

import gameLogic.Equipable;
import globals.BaseAttributes;

public class LongSword extends Item implements Equipable {
	
	public LongSword() {
		super(0, +20, -20, 0, 0, 0, 0, 0, 0, 0);
		BaseAttributes minReq = new BaseAttributes();
		minReq.setStrength(65);
		setMinimumRequirements(minReq);
	}
}
