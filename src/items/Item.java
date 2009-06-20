package items;

import gameLogic.CanPick;
import gameLogic.Consumable;
import gameLogic.Pickable;
import globals.BaseAttributes;
import globals.Modifier;

/**
 * <b>Item</b> is the base class for items. It provides some methods to apply and
 * reset modifiers and to allow setting requirements in an easy way.
 * <p>
 * All items are {@link Pickable}, so they must be either {@link Consumable} or 
 * {@link Equipable}
 * 
 * @author drf
 *
 */
public abstract class Item extends globals.Entity implements gameLogic.Pickable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6452318424066853070L;
	private Modifier modifier;
	private BaseAttributes minimumRequirements;
	private BaseAttributes maximumRequirements;

	/**
	 * Creates a new item, with a modifier carrying the attributes given in the constructor
	 * 
	 * @param intelligence
	 * @param power
	 * @param dexterity
	 * @param magicSkill
	 * @param luck
	 * @param hp
	 * @param bonusMagicDamage
	 * @param bonusMeleeDamage
	 * @param bonusRangedDamage
	 * @param bonusDamageReduction
	 */
	public Item(int intelligence, int power, int dexterity, int magicSkill, int luck,
			int hp, int mp, int bonusMagicDamage, int bonusMeleeDamage, int bonusRangedDamage, 
			int bonusDamageReduction){
		modifier = new Modifier(intelligence, power, dexterity, magicSkill, luck,
				hp, mp, bonusMagicDamage, bonusMeleeDamage, bonusRangedDamage, 
				bonusDamageReduction);
		minimumRequirements = null;
		maximumRequirements = null;
	}

	/**
	 * @return the {@link Modifier} for the item
	 */
	public Modifier getModifier() {
		return modifier;
	}
	
	/**
	 * @return the minimum requirements for picking the item in form of 
	 * {@link BaseAttributes}, or null if the item has no minimum requirements
	 */
	public BaseAttributes getMinimumRequirements() {
		return minimumRequirements;
	}

	/**
	 * Set the minimum requirements for this item in form of {@link BaseAttributes}
	 * 
	 * @param minimumRequirements the new minimum requirements for this item
	 */
	protected void setMinimumRequirements(BaseAttributes minimumRequirements) {
		this.minimumRequirements = minimumRequirements;
	}

	/**
	 * @return the maximum requirements for picking the item in form of 
	 * {@link BaseAttributes}, or null if the item has no maximum requirements
	 */
	public BaseAttributes getMaximumRequirements() {
		return maximumRequirements;
	}

	/**
	 * Set the maximum requirements for this item in form of {@link BaseAttributes}
	 * 
	 * @param maximumRequirements the new maximum requirements for this item
	 */
	protected void setMaximumRequirements(BaseAttributes maximumRequirements) {
		this.maximumRequirements = maximumRequirements;
	}
	
	public BaseAttributes adjustAttrs(BaseAttributes characterAttrs) {
		if (getModifier() != null) {
			return getModifier().adjustAttrs(characterAttrs);
		} else {
			return characterAttrs;
		}
	}
	
	public BaseAttributes resetAttrs(BaseAttributes characterAttrs) {
		if (getModifier() != null) {
			return getModifier().resetAttrs(characterAttrs);
		} else {
			return characterAttrs;
		}
	}
	
	public void onPick(CanPick picker) {
		
	}
}
