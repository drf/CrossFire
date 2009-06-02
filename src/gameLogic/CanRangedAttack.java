package gameLogic;

/**
 * <b>CanRangedAttack</b> grants an object implementing it the capability of performing
 * ranged attacks. It implements also all needed requirements to perform a ranged attack,
 * by exposing all the getters function for the needed attributes.
 * <p>
 * Since performing ranged attacks is both determined by race and attributes conditions,
 * different for each {@link Fighter}, a function that determines whether the target can
 * perform a ranged attack is provided 
 * 
 * @author drf
 *
 */
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
	
	/**
	 * This function serves as a runtime check to see if the object is actually able
	 * to perform a ranged attack. This is needed since ranged attacks can have dynamic
	 * requirements (specific attributes, etc), that can not be determined statically.
	 * 
	 * @return whether the object can perform a ranged attack or not
	 */
	public boolean canRangedAttack();
}
