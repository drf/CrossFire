package spells;

import gameLogic.Attackable;
import gameLogic.CanMagicAttack;

public abstract class Spell {
	
	public abstract int computeDamage(CanMagicAttack caster, Attackable target, int rangeLevel);
	
	private int cost;
	private int distanceRange;
	private int targetRange;
	private String name;
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
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}
	/**
	 * @return the distanceRange
	 */
	public int getDistanceRange() {
		return distanceRange;
	}
	/**
	 * @return the targetRange
	 */
	public int getTargetRange() {
		return targetRange;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	public boolean dealsDamage() {
		return dealsDamage;
	}
	protected void setDealsDamage(boolean deals) {
		dealsDamage = deals;
	}
	public boolean fulfillsSpecialRequirements(CanMagicAttack caster, Attackable target) {
		return true;
	}
	
	
}
