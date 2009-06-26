package gameLogic;

/**
 * <b>CanAttack</b> is the base interface for all interfaces defining an attack type.
 * {@link CanAttack}, groups in it all the common parameters that each attack type shares
 * 
 * @author drf
 *
 */
public abstract interface CanAttack {

	/**
	 * @return the luck of the object implementing the interface
	 */
	public int getLuck();
	
}
