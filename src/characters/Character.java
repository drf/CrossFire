package characters;

import gameChart.Box;
import gameChart.City;
import gameChart.Hill;
import gameChart.Plain;
import globals.BaseAttributes;

import items.Equipable;
import items.Item;

import java.util.ArrayList;
import java.util.Random;

public abstract class Character extends globals.Entity implements gameLogic.Attackable,
                                gameLogic.CanMeleeAttack, gameLogic.CanPick, gameLogic.Movable,
                                java.io.Serializable, gameLogic.CanAttack {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2790814461885173594L;
	private String name;
	private BaseAttributes attributes;
	private ArrayList<items.Item> itemsList = new ArrayList<items.Item>();
	
	public enum Race {
		Human,
		Elf,
		Orc,
		Wizard
	}
	
	public Character() {
		Random r = new Random();
		attributes = new BaseAttributes(r.nextInt(101), r.nextInt(101), r.nextInt(101),
				r.nextInt(101), r.nextInt(101), 100);		
	} 
	
	public Character(int intelligence, int strength, int dexterity, int magicskill, int luck, int HP) {
		attributes = new BaseAttributes(intelligence, strength, dexterity, magicskill, luck, 100);
	}
	
	public static ArrayList<Integer> randomAttributes(int min, int max, int n) {
		Random r = new Random();
		int index, delta;
		ArrayList<Integer> ret = new ArrayList<Integer>();
		int total = r.nextInt(max - min);
		int sum = 0;
		
		for(int i = 0; i < n; i++) {
			int newVal = (total- r.nextInt(n))/n;
			ret.add(newVal);
			sum += newVal;
		}
		delta = total - sum;		
		
		while (delta > 0) {
			index = r.nextInt(n);
			if (ret.get(index) < 100) {
				int diffVal = r.nextInt(delta);
				ret.set(index, ret.get(index) + diffVal);
				if (diffVal == 0) {
					diffVal = 1;
				}
				delta -= diffVal;
			}
		}
		
		return ret;
	}
	
	public Boolean canEquip(items.Item i) {
		if (i.getMaximumRequirements() != null) {
			if (i.getMaximumRequirements().compareTo(attributes) < 0) {
				return false;
			}
		}
		
		if (i.getMinimumRequirements() != null) {
			if (attributes.compareTo(i.getMinimumRequirements()) < 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public void equip(items.Item i) throws EquipError {
		if (this.canEquip(i)) {
			
			removeTerrainChanges(getBox());
			setAttrs(i.adjustAttrs(getAttrs()));
			applyTerrainChanges(getBox());
			
			if(i instanceof Equipable){
				
				if(!this.itemsList.add(i)) 
					throw new EquipError(i.toString() + ": cannot add item");
			}
		}
	}
	
	public void unequip(items.Item i) throws EquipError {
		removeTerrainChanges(getBox());
		setAttrs(i.resetAttrs(getAttrs()));
		applyTerrainChanges(getBox());
		
		if (!this.itemsList.remove(i))
			throw new EquipError(i.toString() + "cannot remove item");
	}
	
	public int getStrength() {
		return attributes.getStrength();
	}
	
	public int getDexterity() {
		return attributes.getDexterity();
	}
	
	public int getIntelligence() {
		return attributes.getIntelligence();
	}
	
	public int getMagicSkill() {
		return attributes.getMagicSkill();
	}
	
	public int getLuck() {
		return attributes.getLuck();
	}
	
	public int getHp() {
		return attributes.getHp();
	}
	
	public void setStrength(int value) {
		attributes.setStrength(value);
	}
	
	public void setDexterity(int value) {
		attributes.setDexterity(value);
	}

	public void setIntelligence(int value) {
		attributes.setIntelligence(value);
	}

	public void setMagicSkill(int value) {
		attributes.setMagicSkill(value);
	}

	public void setLuck(int value) {
		attributes.setLuck(value);
	}
	
	public void setHp(int value) {
		attributes.setHp(value);
	}
	
	public String toString(){
		return "player:" + this.name;
	}
	
	public boolean canRangedAttack() {
		return (getDexterity() + getIntelligence() >= 80);
	}
	
	public boolean canMagicAttack() {
		return (getIntelligence() + getMagicSkill() >= 150);
	}
	
	public void setAttrs(BaseAttributes newAttrs) {
		this.attributes = newAttrs;
	}
	
	public BaseAttributes getAttrs() {
		return this.attributes;
	}
 	
	public void onDeath() {
		
	}
	
	public int getDamageReduction(){
		int damageReduction = 0;
		
		for(Item i: this.itemsList) {
			damageReduction += i.getModifier().getBonusDamageReduction();
		}
		return damageReduction;
	}

	public int getMeleeAttackBonus(){
		int bonusMeleeDamage = 0;
		
		for(Item i: this.itemsList) {
			bonusMeleeDamage += i.getModifier().getBonusMeleeDamage();
		}
		return bonusMeleeDamage;
	}
	
	public int getMagicDamageBonus(){
		int bonusMagicDamage = 0;
		
		for(Item i: this.itemsList) {
			bonusMagicDamage += i.getModifier().getBonusMagicDamage();
		}
		return bonusMagicDamage;
	}

	public int getRangedAttackBonus(){
		int bonusRangedDamage = 0;
		
		for(Item i: this.itemsList) {
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
