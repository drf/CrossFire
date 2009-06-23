package gui;

import gui.GamePanel.ActionState;

import java.util.EventObject;

public class ActionStateChangedEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5086627640870518309L;
	private ActionState state;
	private Integer targetRange;
	private Integer distanceRange;
	
	public ActionStateChangedEvent(Object source, ActionState state, int targetRange, int distanceRange) {
		super(source);
		this.state = state;
		this.targetRange = targetRange;
		this.distanceRange = distanceRange;
	}

	/**
	 * @return the state
	 */
	public ActionState getState() {
		return state;
	}

	/**
	 * @return the targetRange
	 */
	public Integer getTargetRange() {
		return targetRange;
	}

	/**
	 * @return the distanceRange
	 */
	public Integer getDistanceRange() {
		return distanceRange;
	}

	
}
