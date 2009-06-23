package gameLogic;

import java.util.EventObject;

import gameLogic.CombatHandler.AttackType;
import spells.Spell;

public class CombatEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -586172005745729824L;
	private CanAttack attacker;
	private Attackable attacked;
	private CombatHandler.AttackType attackType;
	private int damage;
	private Spell spell;
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
	 * @return the attacker
	 */
	public CanAttack getAttacker() {
		return attacker;
	}

	/**
	 * @return the attacked
	 */
	public Attackable getAttacked() {
		return attacked;
	}

	/**
	 * @return the attackType
	 */
	public CombatHandler.AttackType getAttackType() {
		return attackType;
	}

	/**
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * @return the spell
	 */
	public Spell getSpell() {
		return spell;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

}
