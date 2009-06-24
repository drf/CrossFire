package gameLogic;

import java.util.EventObject;

import player.Player;

import characters.Character;

public class GameSetupEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3511556490562656917L;
	public enum SetupPhase {
		None, 
		AddedPlayer,
		AddPlayer,
		AddedCharacter,
		AddCharacter
	}
	private SetupPhase phase;
	private Character addedCharacter;
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
	public Character getAddedCharacter()
	{
		return addedCharacter;
	}
	
	public Player getAddedPlayer()
	{
		return addedPlayer;
	}
	
	public SetupPhase getPhase() {
		return phase;
	}


}
