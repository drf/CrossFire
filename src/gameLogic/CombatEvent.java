package gameLogic;

import java.util.EventObject;

import gameLogic.CombatHandler.AttackType;
import spells.Spell;

/**
 * @author  drf
 */
public class CombatEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -586172005745729824L;
	/**
	 * @uml.property  name="attacker"
	 * @uml.associationEnd  
	 */
	private CanAttack attacker;
	/**
	 * @uml.property  name="attacked"
	 * @uml.associationEnd  
	 */
	private Attackable attacked;
	/**
	 * @uml.property  name="attackType"
	 * @uml.associationEnd  
	 */
	private CombatHandler.AttackType attackType;
	/**
	 * @uml.property  name="damage"
	 */
	private int damage;
	/**
	 * @uml.property  name="spell"
	 * @uml.associationEnd  
	 */
	private Spell spell;
	/**
	 * @uml.property  name="success"
	 */
	private boolean success;
	
	public CombatEvent(CanAttack from, Attackable to, CombatHandler.AttackType type, int damage, boolean success) {
		super(from);
		this.attacker = from;
		this.attacked = to;
		this.attackType = type;
		this.damage = damage;
		this.success = success;
	}
	
	public CombatEvent(CanAttack from, Attackable to, Spell type, int damage, boolean success) {
		super(from);
		this.attacker = from;
		this.attacked = to;
		this.attackType = AttackType.Magic;
		this.spell = type;
		this.damage = damage;
		this.success = success;
	}

	/**
	 * @return  the attacker
	 * @uml.property  name="attacker"
	 */
	public CanAttack getAttacker() {
		return attacker;
	}

	/**
	 * @return  the attacked
	 * @uml.property  name="attacked"
	 */
	public Attackable getAttacked() {
		return attacked;
	}

	/**
	 * @return  the attackType
	 * @uml.property  name="attackType"
	 */
	public CombatHandler.AttackType getAttackType() {
		return attackType;
	}

	/**
	 * @return  the damage
	 * @uml.property  name="damage"
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * @return  the spell
	 * @uml.property  name="spell"
	 */
	public Spell getSpell() {
		return spell;
	}

	/**
	 * @return  the success
	 * @uml.property  name="success"
	 */
	public boolean isSuccess() {
		return success;
	}

}
