package gameLogic;

import gameLogic.Game.GamePhase;

import java.util.EventObject;

/**
 * @author  drf
 */
public class GamePhaseChangedEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8930126833786289808L;
	/**
	 * @uml.property  name="phase"
	 * @uml.associationEnd  
	 */
	private GamePhase phase;

	public GamePhaseChangedEvent(Object source, GamePhase phase) {
		super(source);
		this.phase = phase;
	}
	
	/**
	 * @return
	 * @uml.property  name="phase"
	 */
	public GamePhase getPhase() {
		return phase;
	}

}
