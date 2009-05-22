package globals;

public class ItemAttributes extends BaseAttributes {

	private int damageIn;
	private int damageOut;
	
	public ItemAttributes() {
		super();
	}

	public ItemAttributes(int intelligence, int power, int dexterity,
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

}
