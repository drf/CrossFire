package items;

import globals.BaseAttributes;
import globals.ItemAttributes;

public abstract class Item extends globals.Entity implements gameLogic.Pickable {
	
	private ItemAttributes modifier;
	private BaseAttributes minimumRequirements;
	private BaseAttributes maximumRequirements;

	public Item(int intelligence, int power, int dexterity, int magicSkill, int luck,
			int damageOut, int damageIn, int hp){
		modifier = new ItemAttributes(intelligence, power, dexterity, magicSkill, luck,
				hp, damageIn, damageOut);
		minimumRequirements = null;
		maximumRequirements = null;
	}

	public ItemAttributes getModifier() {
		return modifier;
	}
	
	public BaseAttributes getMinimumRequirements() {
		return minimumRequirements;
	}

	protected void setMinimumRequirements(BaseAttributes minimumRequirements) {
		this.minimumRequirements = minimumRequirements;
	}

	public BaseAttributes getMaximumRequirements() {
		return maximumRequirements;
	}

	protected void setMaximumRequirements(BaseAttributes maximumRequirements) {
		this.maximumRequirements = maximumRequirements;
	}
}
