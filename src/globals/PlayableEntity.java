package globals;

import gameLogic.Turn;
import player.Player;

/**
 *  
 * PlayableEntity represents an Entity that is able to perform a turn.
 * Playable has the strict meaning of "being able to be used by a player".
 * 
 * The attributes are: 
 * <ul>
 * <li>player it represents an actual player of the type {@link Player}
 * </ul>
 * Each attribute has a getter/setter.
 *
 * @author Dario Freddi
 * @author Vincenzo Iozzo 
 */
public abstract class PlayableEntity extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3398477358319337273L;
	
	private Player player;
	private Turn currentTurn = null;

	public PlayableEntity() {}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Turn getCurrentTurn() {
		return currentTurn;
	}
	
	public boolean isOnTurn() {
		return currentTurn != null;
	}
	
	public void startNewTurn() {
		currentTurn = new Turn();
	}
	
	public void completeTurn() {
		currentTurn = null;
	}
}
