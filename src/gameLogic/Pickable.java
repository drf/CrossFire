package gameLogic;

import globals.BaseAttributes;
import globals.Modifier;

/**
 * <b>Pickable</b> should be implemented by every object that can be picked and used by
 * a {@link CanPick}, such as items. It implements, through getters, minimum and maximum
 * requirements for picking it, and the modifier it provides.
 * 
 * @author drf
 *
 */
public abstract interface Pickable {
	/**
	 * @return the maximum requirements for picking the object implementing the interface,
	 * null if there are no maximum requirements
	 */
	public BaseAttributes getMaximumRequirements();
	/**
	 * @return the minimum requirements for picking the object implementing the interface,
	 * null if there are no maximum requirements
	 */
	public BaseAttributes getMinimumRequirements();
	
	/**
	 * @return the modifier this {@link Pickable} provides, null if it does not provide one
	 * @see Modifier
	 */
	public Modifier getModifier();
}
