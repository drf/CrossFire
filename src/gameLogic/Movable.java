package gameLogic;

import gameChart.Box;

/**
 * <b>Movable</b> grants an object the ability to move on the chart
 * 
 * @author drf
 *
 */
public interface Movable {
	/**
	 * This function gets called whenever the {@link Movable} moves in a different box.
	 * In this function the move event can be handled to perform custom operation
	 * 
	 * @param oldBox the box the object has moved away from
	 * @param newBox the box the object has moved into
	 */
	public void boxChanged(Box oldBox, Box newBox);

}
