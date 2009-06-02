package gameLogic;

public interface CanRangedAttack extends CanAttack {
	
	/**
	 * @return the dexterity of the object implementing the interface
	 */
	public int getDexterity();
	/**
	 * @return the strength of the object implementing the interface
	 */
	public int getStrength();
	/**
	 * @return the ranged damage bonus of the object implementing the interface
	 */
	public int getRangedDamageBonus();
	
	public boolean canRangedAttack();
}
