package characters;

import gameChart.Box;
import gameChart.City;
import gameChart.Hill;
import gameLogic.Equipable;
import gameLogic.PickException;
import gameLogic.Pickable;
import globals.Entity;

import java.util.ArrayList;

public abstract class Character extends Fighter implements gameLogic.Attackable,
                                gameLogic.CanMeleeAttack, gameLogic.CanPick, gameLogic.Movable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2790814461885173594L;
	private ArrayList<Equipable> itemsList = new ArrayList<Equipable>();
	
	public enum Race {
		Human,
		Elf,
		Orc,
		Wizard
	}
	
	public Character() {
		super();
	} 
	
	public Character(int intelligence, int strength, int dexterity, int magicskill, int luck, int HP) {
		super(intelligence, strength, dexterity, magicskill, luck, 100);
	}
	
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
	
	public void unequip(Equipable i) throws PickException {
		removeTerrainChanges(getBox());
		setAttibutes(i.getModifier().resetAttrs(getAttributes()));
		applyTerrainChanges(getBox());
		
		if (!this.itemsList.remove(i)) {
			throw new PickException(i.toString() + "cannot remove item");
		}
	}
	
	public void dropEquip(Equipable i) throws PickException {
		unequip(i);
		((Entity)i).setBox(getBox());	
	}
	
	public boolean canRangedAttack() {
		return (getDexterity() + getIntelligence() >= 80);
	}
	
	public boolean canMagicAttack() {
		return (getIntelligence() + getMagicSkill() >= 150);
	}
 	
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
	
	public int getDamageReduction() {
		int damageReduction = 0;
		
		for (Equipable i: this.itemsList) {
			damageReduction += i.getModifier().getBonusDamageReduction();
		}
		return damageReduction;
	}

	public int getMeleeAttackBonus() {
		int bonusMeleeDamage = 0;
		
		for (Equipable i: this.itemsList) {
			bonusMeleeDamage += i.getModifier().getBonusMeleeDamage();
		}
		return bonusMeleeDamage;
	}
	
	public int getMagicDamageBonus() {
		int bonusMagicDamage = 0;
		
		for (Equipable i: this.itemsList) {
			bonusMagicDamage += i.getModifier().getBonusMagicDamage();
		}
		return bonusMagicDamage;
	}

	public int getRangedAttackBonus() {
		int bonusRangedDamage = 0;
		
		for (Equipable i: this.itemsList) {
			bonusRangedDamage += i.getModifier().getBonusRangedDamage();
		}
		return bonusRangedDamage;
	}
	
	public void boxChanged(Box oldBox, Box newBox) {
		removeTerrainChanges(oldBox);
		applyTerrainChanges(newBox);
	}
	
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
