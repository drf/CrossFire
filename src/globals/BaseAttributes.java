package globals;

public class BaseAttributes implements Comparable<BaseAttributes> {
	private int intelligence;
	private int strength;
	private int dexterity;
	private int magicSkill;
	private int luck;
	private int hp;
	
	public BaseAttributes() {
		this.intelligence = -9999;
		this.strength = -9999;
		this.dexterity = -9999;
		this.magicSkill = -9999;
		this.luck = -9999;
		this.hp = -9999;
	}
	
	public BaseAttributes(int intelligence, int power, int dexterity,
			int magicSkill, int luck, int hp) {
		super();
		this.intelligence = intelligence;
		this.strength = power;
		this.dexterity = dexterity;
		this.magicSkill = magicSkill;
		this.luck = luck;
		this.hp = hp;
	}

	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
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

	public int compareTo(BaseAttributes o) {
		// The object is considered lessThan the other if o has
		// even a single field bigger than this object
		// -9999 reads invalid and will be excluded from the compare
		int ret = 0;

		if (intelligence != -9999 && o.getIntelligence() != -9999) {
			if (intelligence < o.getIntelligence()) {
				return -1;
			} else if (intelligence > o.getIntelligence()) {
				ret = 1;
			}
		}

		if (strength != -9999 && o.getStrength() != -9999) {
			if (strength < o.getStrength()) {
				return -1;
			} else if (strength > o.getStrength()) {
				ret = 1;
			}
		}

		if (dexterity != -9999 && o.getDexterity() != -9999) {
			if (dexterity < o.getDexterity()) {
				return -1;
			} else if (dexterity > o.getDexterity()) {
				ret = 1;
			}
		}

		if (magicSkill != -9999 && o.getMagicSkill() != -9999) {
			if (magicSkill < o.getMagicSkill()) {
				return -1;
			} else if (intelligence > o.getIntelligence()) {
				ret = 1;
			}
		}

		if (luck != -9999 && o.getLuck() != -9999) {
			if (luck < o.getLuck()) {
				return -1;
			} else if (luck > o.getLuck()) {
				ret = 1;
			}
		}
		
		if (hp != -9999 && o.getHp() != -9999) {
			if (hp < o.getHp()) {
				return -1;
			} else if (hp > o.getHp()) {
				ret = 1;
			}
		}
		
		return ret;
	}
	
}
