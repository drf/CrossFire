package globals;

public class Modifier extends BaseAttributes {

	private int damageIn;
	private int damageOut;
	
	public Modifier() {
		super();
	}

	public Modifier(int intelligence, int power, int dexterity,
			int magicSkill, int luck, int hp, int damageIn, int damageOut) {
		super(intelligence, power, dexterity, magicSkill, luck, hp);
		this.damageIn = damageIn;
		this.damageOut = damageOut;
	}

	public int getDamageIn() {
		return damageIn;
	}

	public void setDamageIn(int damageIn) {
		this.damageIn = damageIn;
	}

	public int getDamageOut() {
		return damageOut;
	}

	public void setDamageOut(int damageOut) {
		this.damageOut = damageOut;
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


}
