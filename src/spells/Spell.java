package spells;

import gameLogic.Attackable;
import gameLogic.CanMagicAttack;

/**
 * Base class for spells. Encapsulates all the generic and shared logic to allow creating spells
 * easily.
 * 
 * @author Dario Freddi
 * @author Vincenzo Iozzo
 *
 */
public abstract class Spell {
	
	/**
	 * This funcion has to be reimplemented by each spell. In this function, the damage and/or effect
	 * of the spell should be computed and returned according to specifics (following). This functions
	 * wrap a single target: in fact the rangeLevel parameter indicates at which range level the current
	 * target is in. The logic for computing the range is resolved in {@link CombatHandler}
	 * 
	 * @param caster The {@link CanMagicAttack} casting the spell
	 * @param target The {@link Attackable} on which the spell is being casted upon
	 * @param rangeLevel the range target is far from the main target. If it's 0, then target is the
	 * main target 
	 * @return if the spell deals damage, the damage. If it doesn't any number >= 0 upon success, a number
	 * < 0 upon failure.
	 */
	public abstract int computeDamage(CanMagicAttack caster, Attackable target, int rangeLevel);
	
	/**
	 * @uml.property  name="cost"
	 */
	private int cost;
	/**
	 * @uml.property  name="distanceRange"
	 */
	private int distanceRange;
	/**
	 * @uml.property  name="targetRange"
	 */
	private int targetRange;
	/**
	 * @uml.property  name="name"
	 */
	private String name;
	/**
	 * @uml.property  name="description"
	 */
	private String description;
	private boolean dealsDamage = true;
	
	/**
	 * Creates a new spell with all the base parameters
	 * 
	 * @param cost The cost of the spell in MP
	 * @param distanceRange the maximum distance this spell can be casted from 
	 * @param targetRange the action area of the spell. 0 indicates a single target, 1 indicates
	 * the main target and all its' adjacent entities, etc
	 * @param name the name of the spell
	 * @param description the description of the spell
	 */
	public Spell(int cost, int distanceRange, int targetRange, String name, String description) {
		super();
		this.cost = cost;
		this.distanceRange = distanceRange;
		this.targetRange = targetRange;
		this.name = name;
		this.description = description;
	}
	/**
	 * @return  the cost
	 * @uml.property  name="cost"
	 */
	public int getCost() {
		return cost;
	}
	/**
	 * @return  the distanceRange
	 * @uml.property  name="distanceRange"
	 */
	public int getDistanceRange() {
		return distanceRange;
	}
	/**
	 * @return  the targetRange
	 * @uml.property  name="targetRange"
	 */
	public int getTargetRange() {
		return targetRange;
	}
	/**
	 * @return  the name
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return  the description
	 * @uml.property  name="description"
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * 
	 * @return whether the spell deals damage or not
	 */
	public boolean dealsDamage() {
		return dealsDamage;
	}
	/**
	 * Sets whether this spell deals damage or not
	 * 
	 * @param deals
	 * @uml.property  name="dealsDamage"
	 */
	protected void setDealsDamage(boolean deals) {
		dealsDamage = deals;
	}
	
	/**
	 * This function can be reimplemented by each spell, if it needs a special requirement
	 * from the target/caster
	 * 
	 * @param caster The {@link CanMagicAttack} about to cast the spell
	 * @param target The {@link Attackable} on which the spell is about to be cast
	 * @return
	 */
	public boolean fulfillsSpecialRequirements(CanMagicAttack caster, Attackable target) {
		return true;
	}
	
	
}
