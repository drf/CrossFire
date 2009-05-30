package characters;

import globals.BaseAttributes;

import items.Consumable;
import items.Equipable;

import java.util.ArrayList;
import java.util.Random;

public abstract class Character extends globals.Entity implements gameLogic.Attackable,
                                gameLogic.CanMeleeAttack, gameLogic.CanPick, gameLogic.Movable,
                                java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2790814461885173594L;
	private String name;
	private BaseAttributes attributes;
	private ArrayList<items.Item> itemsList = new ArrayList<items.Item>();
	private ArrayList<BaseAttributes> modifiersList = new ArrayList<BaseAttributes>();
	
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
	
	public Boolean equip(items.Item i) throws EquipError {
		if (this.canEquip(i)) {
			if(i instanceof Consumable) {
				setHp(getHp() + 10);
				return true;
			} else if (i instanceof Equipable) {
				
				if (this.itemsList.add(i)) {
					if (this.modifiersList.add(i.getModifier())) {
						return true;
					}
					else throw new EquipError(i.toString() + ": cannot add modifier");
				}
				else throw new EquipError(i.toString() + ": cannot add item");
			}
			else throw new EquipError(i.toString() + ": cannot determine item type");
		}
		return false;
	}
	
	public Boolean unequip(items.Item i) throws EquipError {
		if (this.itemsList.remove(i)){
			if (this.modifiersList.remove(i.getModifier())){
				return true;
			}
			else throw new EquipError(i.toString() + "cannot remove modifier");
		}
		else throw new EquipError(i.toString() + "cannot remove item");
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
	
	
}
