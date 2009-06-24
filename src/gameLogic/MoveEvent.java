package gameLogic;

import gameChart.Box;

/**
 * @author  drf
 */
public class MoveEvent extends EntityEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1424253419242415952L;
	/**
	 * @uml.property  name="movable"
	 * @uml.associationEnd  
	 */
	private Movable movable;
	/**
	 * @uml.property  name="startingBox"
	 * @uml.associationEnd  
	 */
	private Box startingBox;
	/**
	 * @uml.property  name="destinationBox"
	 * @uml.associationEnd  
	 */
	private Box destinationBox;

	public MoveEvent(Movable source, Box from, Box to) {
		super(source);
		movable = source;
		startingBox = from;
		destinationBox = to;
	}

	/**
	 * @return  the movable
	 * @uml.property  name="movable"
	 */
	public Movable getMovable() {
		return movable;
	}

	/**
	 * @return  the startingBox
	 * @uml.property  name="startingBox"
	 */
	public Box getStartingBox() {
		return startingBox;
	}

	/**
	 * @return  the destinationBox
	 * @uml.property  name="destinationBox"
	 */
	public Box getDestinationBox() {
		return destinationBox;
	}

	
}
