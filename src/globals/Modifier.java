package globals;

/**
 * 
 * <b>Modifier</b> represents a set of attributes for an {@link Entity}. It inherits from {@link BaseAttributes},
 * the main difference between the two is that {@link Modifier} dynamically changes attributes of a given {@link Entity}. 
 * There are other attributes specific to the {@link Modifier}, they are used to dynamically modifies an attack.
 * The attributes are: 
 * <ul>
 * <li>bonusMagicDamage this attribute specifies a bonus for a Magic attack
 * <li>bonusMeleeDamage this attribute specifies a bonus for a Melee attack
 * <li>bonusRangedDamage this attribute specifies a bonus for a Ranged attack
 * <li>bonusDamageReduction this attribute specifies a bonus for damage reductions of an attack
 * </ul>
 * Each attribute has a getter/setter.
 * @author	Dario Freddi
 * @author	Vincenzo Iozzo
 */

public class Modifier extends BaseAttributes {

	private int bonusMagicDamage;
	private int bonusMeleeDamage;
	private int bonusRangedDamage;
	private int bonusDamageReduction;
	
	/**
	 *
     * Class constructor.
     *
	 * This method always returns immediately. 
	 *
	 * @return      An instance of {@link Modifier}.
	 */

	public Modifier() {
		super();
	}

	/**
	 *
     * Class constructor.
     * No checks are performed here on the consistency of the values for a specific {@link Entity}.
	 * This method always returns immediately. 
	 *
	 * @param	bonusDamageReduction
	 * @param	bonusMagicDamage 
	 * @param	bonusMeleeDamage 
	 * @param	bonusRangedDamage 	
	 * @return	An instance of {@link Modifier}.
	 * @see	Modifier
	 */

	public Modifier(int intelligence, int power, int dexterity,
			int magicSkill, int luck, int hp, int bonusMagicDamage, 
			int bonusMeleeDamage, int bonusRangedDamage, int bonusDamageReduction) {
		super(intelligence, power, dexterity, magicSkill, luck, hp);
		this.bonusDamageReduction = bonusDamageReduction;
		this.bonusMagicDamage = bonusMagicDamage;
		this.bonusMeleeDamage = bonusMeleeDamage;
		this.bonusRangedDamage = bonusRangedDamage;
	}

	/**
	 *
     * This method changes the values of a {@link BaseAttributes} with the attributes of this object. It must be called
     * when an {@link Item}Êis picked by a {@Character}
	 * This method always returns immediately. 
	 *
	 * @param	characterAttrs the attributes of a {@link Character}
	 * @return	An instance of {@link BaseAttributes} representing the new attributes of a {@link Character}.
	 * @see		Character
	 * @see		BaseAttributes
	 */

	public BaseAttributes adjustAttrs(BaseAttributes characterAttrs){
		characterAttrs.setIntelligence(characterAttrs.getIntelligence() + getIntelligence());
		characterAttrs.setDexterity(characterAttrs.getDexterity() + getDexterity());
		characterAttrs.setLuck(characterAttrs.getLuck() + getLuck());
		characterAttrs.setMagicSkill(characterAttrs.getMagicSkill() + getMagicSkill());
		characterAttrs.setStrength(characterAttrs.getStrength() + getStrength());
		characterAttrs.setHp(characterAttrs.getHp() + getHp());
		return characterAttrs;
	}

	/**
	 *
     * This method resets the values of a {@link BaseAttributes} with the attributes of this object. It must be called
     * when an {@link Item}Êis dropped by a {@Character}
	 * This method always returns immediately. 
	 *
	 * @param	characterAttrs the attributes of a {@link Character}
	 * @return	An instance of {@link BaseAttributes} representing the new attributes of a {@link Character}.
	 * @see		Character
	 * @see		BaseAttributes
	 */

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
