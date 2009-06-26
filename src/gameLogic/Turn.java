package gameLogic;

import java.util.EnumSet;

public class Turn {
	
	/**
	 * @author   drf
	 */
	public enum Action {
		/**
		 * @uml.property  name="attack"
		 * @uml.associationEnd  
		 */
		Attack,
		/**
		 * @uml.property  name="move"
		 * @uml.associationEnd  
		 */
		Move
	}
	
	EnumSet<Action> actions;
	
	public Turn() {
		// By default, we can attack and move
		actions = EnumSet.of(Action.Attack, Action.Move);
	}
	
	public EnumSet<Action> availableActions() {
		return actions;
	}
	
	public boolean performAction(Action action) {
		if (actions.contains(action)) {
			actions.remove(action);
			return true;
		} else {
			return false;
		}
	}
	
}
