package gameLogic;

import gameLogic.Game.GamePhase;

import java.util.EventObject;

public class GamePhaseChangedEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8930126833786289808L;
	private GamePhase phase;

	public GamePhaseChangedEvent(Object source, GamePhase phase) {
		super(source);
		this.phase = phase;
	}
	
	public GamePhase getPhase() {
		return phase;
	}

}
