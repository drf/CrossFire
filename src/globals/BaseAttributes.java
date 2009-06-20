package globals;

/**
 * 
 * <b>BaseAttributes</b> represents a set of attributes for an {@link Entity}.
 * The attributes are: 
 * <ul>
 * <li>intelligence the intelligence an {@link Entity} has, if used by a {@link Modifier} represents a bonus value
 * <li>power the power an {@link Entity} has, if used by a {@link Modifier} represents a bonus value
 * <li>dexterity the dexterity an {@link Entity} has, if used by a {@link Modifier} represents a bonus value
 * <li>magicSkill the magic skill an {@link Entity} has, if used by a {@link Modifier} represents a bonus value
 * <li>luck the luck an {@link Entity} has, if used by a {@link Modifier} represents a bonus value
 * <li>hp	the vital points an {@link Entity} has, if used by a {@link Modifier} represents a bonus value
 * </ul>
 * Each attribute has a getter/setter.
 * @author	Dario Freddi
 * @author	Vincenzo Iozzo
 */

public class BaseAttributes implements Comparable<BaseAttributes> {
	private int intelligence;
	private int strength;
	private int dexterity;
	private int magicSkill;
	private int luck;
	private int hp;
	private int mp;
	
	/**
	 *
     * Class constructor.
     *
	 * 
	 * This method always returns immediately. 
	 *
	 * @return      An instance of {@link BaseAttributes}
	 */
	public BaseAttributes() {
		this.intelligence = 0;
		this.strength = 0;
		this.dexterity = 0;
		this.magicSkill = 0;
		this.luck = 0;
		this.hp = 0;
		this.mp = 0;
	}
	
	/**
	 * Class constructor.
	 * 
	 * Returns a BaseAttribute object that can by associated with an {@link Entity}. 
	 * No checks are performed here on the consistency of the values for a specific {@link Entity}.
	 * If it used inside a {@link Character} this object represents the attributes for it, when used
	 * for a {@link Item} it represents "modifier" values which need to be applied to a given {@link Character}
	 * 
	 * This method always returns immediately. 
	 *
	 * @param	intelligence 
	 * @param	power 
	 * @param	dexterity 
	 * @param	magicSkill 
	 * @param	luck 
	 * @param	hp	
	 * @return	An instance of {@link BaseAttributes}
	 * @see 	BaseAttributes
	 */
	public BaseAttributes(int intelligence, int power, int dexterity,
			int magicSkill, int luck, int hp, int mp) {
		super();
		this.intelligence = intelligence;
		this.strength = power;
		this.dexterity = dexterity;
		this.magicSkill = magicSkill;
		this.luck = luck;
		this.hp = hp;
		this.mp = mp;
	}

	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getDexterity() {
		return dexterity;
	}
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	public int getMagicSkill() {
		return magicSkill;
	}
	public void setMagicSkill(int magicSkill) {
		this.magicSkill = magicSkill;
	}
	public int getLuck() {
		return luck;
	}
	public void setLuck(int luck) {
		this.luck = luck;
	}
	
	/**
	 * Returns a value which represents the similarity between two objects.
	 * By similarity we mean that each attribute (integer) is compared
	 * 
	 * This method always returns immediately. 
	 *
	 * @param  o  a BaseAttributes object which must be compared
	 * @return      0 if they are equal, -1 if the first object passed as a parameter is greater, 1 if this object is greater
	 */

	public int compareTo(BaseAttributes o) {
		int ret = 0;

		if (intelligence != 0 && o.getIntelligence() != 0) {
			if (intelligence < o.getIntelligence()) {
				return -1;
			} else if (intelligence > o.getIntelligence()) {
				ret = 1;
			}
		}

		if (strength != 0 && o.getStrength() != 0) {
			if (strength < o.getStrength()) {
				return -1;
			} else if (strength > o.getStrength()) {
				ret = 1;
			}
		}

		if (dexterity != 0 && o.getDexterity() != 0) {
			if (dexterity < o.getDexterity()) {
				return -1;
			} else if (dexterity > o.getDexterity()) {
				ret = 1;
			}
		}

		if (magicSkill != 0 && o.getMagicSkill() != 0) {
			if (magicSkill < o.getMagicSkill()) {
				return -1;
			} else if (intelligence > o.getIntelligence()) {
				ret = 1;
			}
		}

		if (luck != 0 && o.getLuck() != 0) {
			if (luck < o.getLuck()) {
				return -1;
			} else if (luck > o.getLuck()) {
				ret = 1;
			}
		}
		
		if (hp != 0 && o.getHp() != 0) {
			if (hp < o.getHp()) {
				return -1;
			} else if (hp > o.getHp()) {
				ret = 1;
			}
		}
		
		if (mp != 0 && o.getMp() != 0) {
			if (mp < o.getMp()) {
				return -1;
			} else if (mp > o.getMp()) {
				ret = 1;
			}
		}
		
		return ret;
	}
	
}
