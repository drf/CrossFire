package globals;

/**
 * 
 * <b>Pair</b> represents a set of coordinates. The primary use is for bidimensional shapes.
 * This class inherits from Enum.
 * The attributes are: 
 * <ul>
 * <li>a this is one of the coordinate
 * <li>b this is the other coordinate
 * </ul>
 * @author	Dario Freddi
 * @author	Vincenzo Iozzo
 */

public class Pair<E> {
	private E a;
	private E b;

	/**
	 *
     * Class constructor.
     * 
	 * This method always returns immediately. 
	 *
	 * @return      An instance of {@link Pair}.
	 */

	public Pair() {
		a = null;
		b = null;
	}
	
	/**
	 *
     * Class constructor. It sets a pair of coordinate
     * 
	 * This method always returns immediately.
	 * 
	 * @param	a first coordinate
	 * @param	b second coordinate
	 *
	 * @return      An instance of {@link Pair}.
	 */

	public Pair(E a, E b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	/**
	 *
     * This is the getter for the second coordinate
     * 
	 * This method always returns immediately. 
	 *
	 * @return      An instance of {@link E}.
	 */

	public E getSecond() {
		return b;
	}
	
	/**
	 *
	 * This is the setter for the first coordinate
	 *
	 * This method always returns immediately. 
	 *
	 * @param		first the second coordinate
	 * @return      void.
	 */

	public void setSecond(E second) {
		this.b = second;
	}
	
	/**
	 *
	 * This is the setter for the first coordinate
	 *
	 * This method always returns immediately. 
	 *
	 * @param		first the first coordinate
	 * @return      void.
	 */

	public void setFirst(E first) {
		this.a = first;
	}

	/**
	 *
     * This is the getter for the first coordinate
     * 
	 * This method always returns immediately. 
	 *
	 * @return      An instance of {@link E}.
	 */

	public E getFirst() {
		return a;
	}	
}
