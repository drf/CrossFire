package items;

import gameChart.Box;
import globals.BaseAttributes;
import globals.Modifier;

public abstract class Item extends globals.Entity implements gameLogic.Pickable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6452318424066853070L;
	private Modifier modifier;
	private BaseAttributes minimumRequirements;
	private BaseAttributes maximumRequirements;

	public Item(int intelligence, int power, int dexterity, int magicSkill, int luck,
			int hp, int bonusMagicDamage, int bonusMeleeDamage, int bonusRangedDamage, 
			int bonusDamageReduction){
		modifier = new Modifier(intelligence, power, dexterity, magicSkill, luck,
				hp, bonusMagicDamage, bonusMeleeDamage, bonusRangedDamage, 
				bonusDamageReduction);
		minimumRequirements = null;
		maximumRequirements = null;
	}

	public Modifier getModifier() {
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
	
	public BaseAttributes adjustAttrs(BaseAttributes characterAttrs){
		return getModifier().adjustAttrs(characterAttrs);
	}
	
	public BaseAttributes resetAttrs(BaseAttributes characterAttrs){
		return getModifier().resetAttrs(characterAttrs);
	}

	public void boxChanged(Box oldBox, Box newBox) {
		
	}	
}
