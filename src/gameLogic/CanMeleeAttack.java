package gameLogic;

/**
 * <b>CanMeleeAttack</b> grants an object implementing it the capability of performing
 * melee attacks. It implements also all needed requirements to perform a melee attack,
 * by exposing all the getters function for the needed attributes.
 * 
 * @author drf
 *
 */
public interface CanMeleeAttack extends CanAttack {
	/**
	 * @return the strength of the object implementing the interface
	 */
	public int getStrength();
	/**
	 * @return the melee attack bonus of the object implementing the interface
	 */
	public int getMeleeDamageBonus();
	
}
