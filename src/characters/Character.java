package characters;

import gameChart.Box;
import gameChart.City;
import gameChart.Hill;
import gameLogic.Equipable;
import gameLogic.Movable;
import gameLogic.PickException;
import gameLogic.Pickable;
import globals.Entity;

import java.util.ArrayList;

/**
 * 
 * <b>Character</b> represents a {@link Fighter} that is the main entity a human
 * player can control. Characters react to terrain changes, can equip and use items,
 * and are able to perform a set of attacks. 
 * <p>
 * Character is abstract: in fact a valid character has a race, one between:
 * <ul>
 * <li>{@link Human}</li>
 * <li>{@link Elf}</li>
 * <li>{@link Orc}</li>
 * <li>{@link Wizard}</li>
 * </ul>
 *
 * More information on these races can be found in each race's class
 * 
 * @author Dario Freddi
 * @author Vincenzo Iozzo
 * 
 * @see Fighter
 */
public abstract class Character extends Fighter implements gameLogic.Attackable,
                                gameLogic.CanMeleeAttack, gameLogic.CanPick, gameLogic.Movable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2790814461885173594L;
	private ArrayList<Equipable> itemsList = new ArrayList<Equipable>();
	
	/**
	 * Represent a race of a Character
	 * 
	 * @author Dario Freddi
	 * @author Vincenzo Iozzo
	 */
	public enum Race {
		Human,
		Elf,
		Orc,
		Wizard
	}
	
	/**
	 * Default constructor, create a character with random attributes
	 * 
	 * @see Fighter.Fighter()
	 */
	public Character() {
		super();
	} 
	
	/**
	 * Creates a new character with the given attributes
	 * 
	 * @param intelligence the character's intelligence
	 * @param strength the character's strength
	 * @param dexterity the character's dexterity
	 * @param magicskill the character's magic skill
	 * @param luck the character's luck
	 * @param HP the character's health points
	 */
	public Character(int intelligence, int strength, int dexterity, int magicskill, int luck, int HP) {
		super(intelligence, strength, dexterity, magicskill, luck, 100);
	}
	
	/**
	 * Check if the character is able to pick the given {@link Pickable}.
	 * 
	 * @param i the {@link Pickable} to check
	 * @return whether the character is able to pick it or not
	 * @see Pickable
	 */
	public Boolean canPick(Pickable i) {
		if (i.getMaximumRequirements() != null) {
			if (i.getMaximumRequirements().compareTo(getAttributes()) < 0) {
				return false;
			}
		}
		
		if (i.getMinimumRequirements() != null) {
			if (getAttributes().compareTo(i.getMinimumRequirements()) < 0) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Pick a {@link Pickable} and resolve it. If it is {@link Equipable}, the item
	 * will be equipped. The modifiers of the {@link Pickable} will be resolved when
	 * this function gets called
	 * 
	 * @param i the {@link Pickable} to pick
	 * @throws PickException
	 */
	public void pick(Pickable i) throws PickException {
		if (this.canPick(i)) {
			
			removeTerrainChanges(getBox());
			setAttibutes(i.getModifier().adjustAttrs(getAttributes()));
			applyTerrainChanges(getBox());
			
			if(i instanceof Equipable) {
				if(!this.itemsList.add((Equipable)i)) 
					throw new PickException(i.toString() + ": cannot add item");
			}
		}
	}
	
	/**
	 * Removes from the equipment an {@link Equipable}, removing its modifiers
	 * from the character.
	 * 
	 * @param i the {@link Equipable} to remove
	 * @throws PickException
	 */
	public void unequip(Equipable i) throws PickException {
		removeTerrainChanges(getBox());
		setAttibutes(i.getModifier().resetAttrs(getAttributes()));
		applyTerrainChanges(getBox());
		
		if (!this.itemsList.remove(i)) {
			throw new PickException(i.toString() + "cannot remove item");
		}
	}
	
	/**
	 * Unequips and drops on the current box an {@link Equipable}
	 * 
	 * @param i the {@link Equipable} to drop
	 * @throws PickException
	 * @see unequip
	 */
	public void dropEquip(Equipable i) throws PickException {
		unequip(i);
		((Entity)i).setBox(getBox());	
	}
	
	/**
	 * @return whether this character can perform a ranged attack or not
	 */
	public boolean canRangedAttack() {
		return (getDexterity() + getIntelligence() >= 80);
	}
	
	/**
	 * @return whether this character can perform a magic attack or not
	 */
	public boolean canMagicAttack() {
		return (getIntelligence() + getMagicSkill() >= 150);
	}
 	
	/**
	 * Reimplemented from {@link Attackable}. The character will drop all
	 * of its equipment on the current box
	 */
	public void onDeath() {
		for(Equipable i: this.itemsList) {
			if (i instanceof Equipable) {
				try {
					dropEquip(i);
				} catch (PickException e) {
					
				}
			}
		}
	}
	
	/**
	 * @return the damage reduction for this character
	 */
	public int getDamageReduction() {
		int damageReduction = 0;
		
		for (Equipable i: this.itemsList) {
			damageReduction += i.getModifier().getBonusDamageReduction();
		}
		return damageReduction;
	}

	/**
	 * @return the melee attack bonus for this character
	 */
	public int getMeleeAttackBonus() {
		int bonusMeleeDamage = 0;
		
		for (Equipable i: this.itemsList) {
			bonusMeleeDamage += i.getModifier().getBonusMeleeDamage();
		}
		return bonusMeleeDamage;
	}
	
	/**
	 * @return the magic damage bonus for this character
	 */
	public int getMagicDamageBonus() {
		int bonusMagicDamage = 0;
		
		for (Equipable i: this.itemsList) {
			bonusMagicDamage += i.getModifier().getBonusMagicDamage();
		}
		return bonusMagicDamage;
	}

	/**
	 * @return the ranged attack bonus for this character
	 */
	public int getRangedAttackBonus() {
		int bonusRangedDamage = 0;
		
		for (Equipable i: this.itemsList) {
			bonusRangedDamage += i.getModifier().getBonusRangedDamage();
		}
		return bonusRangedDamage;
	}
	
	/**
	 * Reimplemented from {@link Movable}. Applies terrain changes according to
	 * the box type
	 * 
	 * @param oldBox the old box
	 * @param newBox the box on which the character has moved
	 */
	public void boxChanged(Box oldBox, Box newBox) {
		removeTerrainChanges(oldBox);
		applyTerrainChanges(newBox);
	}
	
	/**
	 * Applies some changes to the attributes according to the type of the terrain,
	 * according to the specifics of the game
	 * 
	 * @param box the box on which the character stands
	 */
	private void applyTerrainChanges(Box box) {
		if (box instanceof Hill) {
			if (getDexterity() < 50) {
				setStrength(getStrength() - 10);
			} else if (getDexterity() >= 60) {
				setStrength(getStrength() + 10);
			}
		} else if (box instanceof City) {
			if (getIntelligence() > 60) {
				setMagicSkill(getMagicSkill() + 10);
			} else if (getIntelligence() <= 50) {
				setDexterity(getDexterity() - 10);
			}
		}
	}
	
	/**
	 * Removes changes made to the attributes according to the type of the terrain,
	 * according to the specifics of the game
	 * 
	 * @param box the box on which the character stands
	 */
	private void removeTerrainChanges(Box box) {
		if (box instanceof Hill) {
			if (getDexterity() < 50) {
				setStrength(getStrength() + 10);
			} else if (getDexterity() >= 60) {
				setStrength(getStrength() - 10);
			}
		} else if (box instanceof City) {
			if (getIntelligence() > 60) {
				setMagicSkill(getMagicSkill() - 10);
			} else if (getIntelligence() <= 50) {
				setDexterity(getDexterity() + 10);
			}
		}
	}
}
