package globals;

import gameLogic.EntityListener;
import gameLogic.Turn;
import gameLogic.TurnEvent;
import gameLogic.TurnEvent.TypeEvent;
import player.Player;

/**
 * PlayableEntity represents an Entity that is able to perform a turn. Playable has the strict meaning of "being able to be used by a player". The attributes are:  <ul> <li>player it represents an actual player of the type  {@link Player} </ul> Each attribute has a getter/setter.
 * @author  Dario Freddi
 * @author  Vincenzo Iozzo
 */
public abstract class PlayableEntity extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3398477358319337273L;
	
	/**
	 * @uml.property  name="player"
	 * @uml.associationEnd  
	 */
	private Player player;
	/**
	 * @uml.property  name="currentTurn"
	 * @uml.associationEnd  
	 */
	private Turn currentTurn = null;

	public PlayableEntity() {}

	
	
	public PlayableEntity(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}



	/**
	 * @return
	 * @uml.property  name="player"
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player
	 * @uml.property  name="player"
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	/**
	 * @return
	 * @uml.property  name="currentTurn"
	 */
	public Turn getCurrentTurn() {
		return currentTurn;
	}
	
	public boolean isOnTurn() {
		return currentTurn != null;
	}
	
	public void startNewTurn() {
		currentTurn = new Turn();
		
		// Stream the event
		TurnEvent evt = new TurnEvent(player, this, TypeEvent.Started);
		
		Object[] listeners = getListeners().getListenerList();
        
        for (int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == EntityListener.class) {
            	((EntityListener)listeners[i+1]).EntityEventOccurred(evt);
            }
        }
	}
	
	public void completeTurn() {
		
		// Stream the event
		TurnEvent evt = new TurnEvent(player, this, TypeEvent.Finished);
		
		Object[] listeners = getListeners().getListenerList();
        
        for (int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == EntityListener.class) {
            	((EntityListener)listeners[i+1]).EntityEventOccurred(evt);
            }
        }
		
		currentTurn = null;
	}
	
	public boolean performTurnAction(Turn.Action action) {
		if (currentTurn.performAction(action)) {
			
			// Stream the event
			TurnEvent evt = new TurnEvent(player, this, TypeEvent.Changed);
			
			Object[] listeners = getListeners().getListenerList();
	        
	        for (int i = 0; i < listeners.length; i += 2) {
	            if (listeners[i] == EntityListener.class) {
	            	((EntityListener)listeners[i+1]).EntityEventOccurred(evt);
	            }
	        }
			
			return true;
		} else {
			return false;
		}
	}
}
