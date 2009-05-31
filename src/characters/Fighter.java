package characters;

import java.util.ArrayList;
import java.util.Random;

import globals.BaseAttributes;
import globals.PlayableEntity;

public abstract class Fighter extends PlayableEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5913662304478085454L;
	private String name;
	private BaseAttributes attributes;

	public Fighter() {
		super();
		Random r = new Random();
		attributes = new BaseAttributes(r.nextInt(101), r.nextInt(101), r.nextInt(101),
				r.nextInt(101), r.nextInt(101), 100);		
	}
	
	public Fighter(int intelligence, int strength, int dexterity, int magicskill, int luck, int HP) {
		attributes = new BaseAttributes(intelligence, strength, dexterity, magicskill, luck, HP);
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
	
	public String toString() {
		return "fighter:" + this.name;
	}
	
	public void setAttibutes(BaseAttributes newAttrs) {
		this.attributes = newAttrs;
	}
	
	public BaseAttributes getAttributes() {
		return this.attributes;
	}
}
