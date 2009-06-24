package spells;

import gameLogic.Attackable;
import gameLogic.CanMagicAttack;

/**
 * @author  drf
 */
public abstract class Spell {
	
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
	public boolean dealsDamage() {
		return dealsDamage;
	}
	/**
	 * @param deals
	 * @uml.property  name="dealsDamage"
	 */
	protected void setDealsDamage(boolean deals) {
		dealsDamage = deals;
	}
	public boolean fulfillsSpecialRequirements(CanMagicAttack caster, Attackable target) {
		return true;
	}
	
	
}
