package gameLogic;

import gameChart.Box;

public class MoveEvent extends EntityEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1424253419242415952L;
	private Movable movable;
	private Box startingBox;
	private Box destinationBox;

	public MoveEvent(Movable source, Box from, Box to) {
		super(source);
		movable = source;
		startingBox = from;
		destinationBox = to;
	}

	/**
	 * @return the movable
	 */
	public Movable getMovable() {
		return movable;
	}

	/**
	 * @return the startingBox
	 */
	public Box getStartingBox() {
		return startingBox;
	}

	/**
	 * @return the destinationBox
	 */
	public Box getDestinationBox() {
		return destinationBox;
	}

	
}
