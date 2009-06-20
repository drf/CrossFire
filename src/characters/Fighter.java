package characters;

import java.util.ArrayList;
import java.util.Random;

import globals.BaseAttributes;
import globals.PlayableEntity;

/**
 * Fighter is the main class for each playable entity that has combat attributes.
 * Each class inheriting from fighter will be provided with all the attributes belonging
 * to {@link BaseAttributes} and a name.
 * 
 * 
 * @author Dario Freddi
 * @author Vincenzo Iozzo
 * @see BaseAttributes
 *
 */
public abstract class Fighter extends PlayableEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5913662304478085454L;
	private String name;
	private BaseAttributes attributes;

	/**
	 * Default constructor. Create a new fighter with random attributes, each one ranging
	 * from 0 to 100
	 */
	public Fighter() {
		super();
		Random r = new Random();
		attributes = new BaseAttributes(r.nextInt(101), r.nextInt(101), r.nextInt(101),
				r.nextInt(101), r.nextInt(101), 100, 100);		
	}
	
	/**
	 * Create a new fighter with the specified parameters
	 * 
	 * @param intelligence the fighter's intelligence
	 * @param strength the fighter's strength
	 * @param dexterity the fighter's dexterity
	 * @param magicskill the fighter's magic skill
	 * @param luck the fighter's luck
	 * @param HP the fighter's health points
	 */
	public Fighter(int intelligence, int strength, int dexterity, int magicskill, int luck, int HP, int MP) {
		attributes = new BaseAttributes(intelligence, strength, dexterity, magicskill, luck, HP, MP);
	}
	
	/**
	 * Generate a set of random numbers, ranging from min and max. This function
	 * can be used to generate semi-random attributes starting from a base rule
	 * 
	 * @param min The minimum value of the randomizer
	 * @param max The maximum value of the randomizer
	 * @param n The quantity of numbers that should be generated
	 * @return
	 */
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
	
	/**
	 * @return The strength of the fighter
	 */
	public int getStrength() {
		return attributes.getStrength();
	}
	
	/**
	 * @return The dexterity of the fighter
	 */
	public int getDexterity() {
		return attributes.getDexterity();
	}
	
	/**
	 * @return The intelligence of the fighter
	 */
	public int getIntelligence() {
		return attributes.getIntelligence();
	}
	
	/**
	 * @return The magic skill of the fighter
	 */
	public int getMagicSkill() {
		return attributes.getMagicSkill();
	}
	
	/**
	 * @return The luck of the fighter
	 */
	public int getLuck() {
		return attributes.getLuck();
	}
	
	/**
	 * @return The health points of the fighter
	 */
	public int getHp() {
		return attributes.getHp();
	}
	
	/**
	 * @return The magic points of the fighter
	 */
	public int getMp() {
		return attributes.getMp();
	}
	
	/**
	 * @param value the new strength for the fighter
	 */
	public void setStrength(int value) {
		attributes.setStrength(value);
	}
	
	/**
	 * @param value the new dexterity for the fighter
	 */
	public void setDexterity(int value) {
		attributes.setDexterity(value);
	}

	/**
	 * @param value the new intelligence for the fighter
	 */
	public void setIntelligence(int value) {
		attributes.setIntelligence(value);
	}

	/**
	 * @param value the new magic skill for the fighter
	 */
	public void setMagicSkill(int value) {
		attributes.setMagicSkill(value);
	}

	/**
	 * @param value the new luck for the fighter
	 */
	public void setLuck(int value) {
		attributes.setLuck(value);
	}
	
	/**
	 * @param value the new health points for the fighter
	 */
	public void setHp(int value) {
		attributes.setHp(value);
	}
	
	/**
	 * @param value the new magic points for the fighter
	 */
	public void setMp(int value) {
		attributes.setMp(value);
	}
	
	public String toString() {
		return "fighter:" + this.name;
	}
	
	/**
	 * Set the new attributes for this fighter
	 * 
	 * @param newAttrs a {@link BaseAttributes} object carrying the new attributes
	 */
	public void setAttibutes(BaseAttributes newAttrs) {
		this.attributes = newAttrs;
	}
	
	/**
	 * Get all the attributes for this fighter
	 * 
	 * @return a {@link BaseAttributes} object carrying the attributes of the fighter
	 */
	public BaseAttributes getAttributes() {
		return this.attributes;
	}
}
