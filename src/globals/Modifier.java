package globals;

public class Modifier extends BaseAttributes {

	private int bonusMagicDamage;
	private int bonusMeleeDamage;
	private int bonusRangedDamage;
	private int bonusDamageReduction;
	
	public Modifier() {
		super();
	}

	public Modifier(int intelligence, int power, int dexterity,
			int magicSkill, int luck, int hp, int bonusMagicDamage, 
			int bonusMeleeDamage, int bonusRangedDamage, int bonusDamageReduction) {
		super(intelligence, power, dexterity, magicSkill, luck, hp);
		this.bonusDamageReduction = bonusDamageReduction;
		this.bonusMagicDamage = bonusMagicDamage;
		this.bonusMeleeDamage = bonusMeleeDamage;
		this.bonusRangedDamage = bonusRangedDamage;
	}
	
	public BaseAttributes adjustAttrs(BaseAttributes characterAttrs){
		characterAttrs.setIntelligence(characterAttrs.getIntelligence() + getIntelligence());
		characterAttrs.setDexterity(characterAttrs.getDexterity() + getDexterity());
		characterAttrs.setLuck(characterAttrs.getLuck() + getLuck());
		characterAttrs.setMagicSkill(characterAttrs.getMagicSkill() + getMagicSkill());
		characterAttrs.setStrength(characterAttrs.getStrength() + getStrength());
		characterAttrs.setHp(characterAttrs.getHp() + getHp());
		return characterAttrs;
	}
	
	public BaseAttributes resetAttrs(BaseAttributes characterAttrs){
		characterAttrs.setIntelligence(characterAttrs.getIntelligence() - getIntelligence());
		characterAttrs.setDexterity(characterAttrs.getDexterity() - getDexterity());
		characterAttrs.setLuck(characterAttrs.getLuck() - getLuck());
		characterAttrs.setMagicSkill(characterAttrs.getMagicSkill() - getMagicSkill());
		characterAttrs.setStrength(characterAttrs.getStrength() - getStrength());
		characterAttrs.setHp(characterAttrs.getHp() - getHp());
		return characterAttrs;
	
	}
	
	public int getBonusMagicDamage() {
		return bonusMagicDamage;
	}

	public void setBonusMagicDamage(int bonusMagicDamage) {
		this.bonusMagicDamage = bonusMagicDamage;
	}

	public int getBonusMeleeDamage() {
		return bonusMeleeDamage;
	}

	public void setBonusMeleeDamage(int bonusMeleeDamage) {
		this.bonusMeleeDamage = bonusMeleeDamage;
	}

	public int getBonusRangedDamage() {
		return bonusRangedDamage;
	}

	public void setBonusRangedDamage(int bonusRangedDamage) {
		this.bonusRangedDamage = bonusRangedDamage;
	}

	public int getBonusDamageReduction() {
		return bonusDamageReduction;
	}

	public void setBonusDamageReduction(int bonusDamageReduction) {
		this.bonusDamageReduction = bonusDamageReduction;
	}

}
