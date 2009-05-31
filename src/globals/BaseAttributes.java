package globals;

public class BaseAttributes implements Comparable<BaseAttributes> {
	private int intelligence;
	private int strength;
	private int dexterity;
	private int magicSkill;
	private int luck;
	private int hp;
	
	public BaseAttributes() {
		this.intelligence = 0;
		this.strength = 0;
		this.dexterity = 0;
		this.magicSkill = 0;
		this.luck = 0;
		this.hp = 0;
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
		
		return ret;
	}
	
}
