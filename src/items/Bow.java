package items;

import globals.BaseAttributes;

public class Bow extends Item {

	public Bow() {
		super(0, 0, 0, 0, 0, 0, 0, 0, +10, 0);
		BaseAttributes min = new BaseAttributes();
		min.setLuck(50);
		min.setDexterity(50);
		setMinimumRequirements(min);
	}
}
