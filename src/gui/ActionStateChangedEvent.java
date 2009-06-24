package gui;

import gui.GamePanel.ActionState;

import java.util.EventObject;

/**
 * @author  drf
 */
public class ActionStateChangedEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5086627640870518309L;
	/**
	 * @uml.property  name="state"
	 * @uml.associationEnd  
	 */
	private ActionState state;
	/**
	 * @uml.property  name="targetRange"
	 */
	private Integer targetRange;
	/**
	 * @uml.property  name="distanceRange"
	 */
	private Integer distanceRange;
	
	public ActionStateChangedEvent(Object source, ActionState state, int targetRange, int distanceRange) {
		super(source);
		this.state = state;
		this.targetRange = targetRange;
		this.distanceRange = distanceRange;
	}

	/**
	 * @return  the state
	 * @uml.property  name="state"
	 */
	public ActionState getState() {
		return state;
	}

	/**
	 * @return  the targetRange
	 * @uml.property  name="targetRange"
	 */
	public Integer getTargetRange() {
		return targetRange;
	}

	/**
	 * @return  the distanceRange
	 * @uml.property  name="distanceRange"
	 */
	public Integer getDistanceRange() {
		return distanceRange;
	}

	
}
