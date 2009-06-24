package gameLogic;

import java.util.EventObject;

import player.Player;

import characters.Character;

/**
 * @author  drf
 */
public class GameSetupEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3511556490562656917L;
	/**
	 * @author   drf
	 */
	public enum SetupPhase {
		/**
		 * @uml.property  name="none"
		 * @uml.associationEnd  
		 */
		None, 
		/**
		 * @uml.property  name="addedPlayer"
		 * @uml.associationEnd  
		 */
		AddedPlayer,
		/**
		 * @uml.property  name="addPlayer"
		 * @uml.associationEnd  
		 */
		AddPlayer,
		/**
		 * @uml.property  name="addedCharacter"
		 * @uml.associationEnd  
		 */
		AddedCharacter,
		/**
		 * @uml.property  name="addCharacter"
		 * @uml.associationEnd  
		 */
		AddCharacter
	}
	/**
	 * @uml.property  name="phase"
	 * @uml.associationEnd  
	 */
	private SetupPhase phase;
	/**
	 * @uml.property  name="addedCharacter"
	 * @uml.associationEnd  
	 */
	private Character addedCharacter;
	/**
	 * @uml.property  name="addedPlayer"
	 * @uml.associationEnd  
	 */
	private Player addedPlayer;
	
	public GameSetupEvent(Object source, SetupPhase newPhase, Character newChar) {
		super(source);
		phase = newPhase;
		addedCharacter = newChar;
		addedPlayer = null;
	
	}
	
	public GameSetupEvent(Object source, SetupPhase newPhase, Player newPlayer) {
		super(source);
		phase = newPhase;
		addedPlayer = newPlayer;
		addedCharacter = null;
	}
	
	public GameSetupEvent(Object source, SetupPhase newPhase)
	{
		super(source);
		phase = newPhase;
		addedPlayer = null;
		addedCharacter = null;
	}
	/**
	 * @return
	 * @uml.property  name="addedCharacter"
	 */
	public Character getAddedCharacter()
	{
		return addedCharacter;
	}
	
	/**
	 * @return
	 * @uml.property  name="addedPlayer"
	 */
	public Player getAddedPlayer()
	{
		return addedPlayer;
	}
	
	/**
	 * @return
	 * @uml.property  name="phase"
	 */
	public SetupPhase getPhase() {
		return phase;
	}


}
