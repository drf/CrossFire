package gameLogic;

/**
 * <b>CanPick</b> grants an object the ability to pick {@link Pickable} objects.
 * 
 * @author drf
 *
 */
public interface CanPick {
	/**
	 * Pick a {@link Pickable}. In this function all the logic for checking if an
	 * object can be picked or not, and all the subsequent effects, should be handled
	 * 
	 * @param i the {@link Pickable} to pick
	 * @throws PickException
	 */
	public boolean pick(Pickable i);
	public boolean canPick(Pickable i);
}
