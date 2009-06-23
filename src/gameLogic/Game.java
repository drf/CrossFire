package gameLogic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

import javax.swing.event.EventListenerList;

import characters.Character;
import characters.Elf;
import characters.Fighter;
import characters.Human;
import characters.Orc;
import characters.Wizard;

import player.Player;

import gameChart.AbstractChart;
import globals.Modifier;
import globals.PlayableEntity;

public class Game {
	private AbstractChart chart;
	private HashMap<PlayableEntity, Player> entities = new HashMap<PlayableEntity, Player>();
	private GamePhase state;
	private static Game instance = null;
	private HashMap<Integer, PlayableEntity> turnTokens = new HashMap<Integer, PlayableEntity>();
	private HashSet<PlayableEntity> turnQueue = new HashSet<PlayableEntity>();
	
	// Event Listeners
	EventListenerList eventListeners = new EventListenerList();

	public enum GamePhase {
		None,
		GameCreation,
		CharacterSetup,
		Turn,
		EndGame
	}
	
	private Game() {}
	
	public static Game getInstance() {
		if (instance == null) {
			instance = new Game();
		}
		
		return instance;
	}
	
	public GamePhase getState() {
		return state;
	}
	
	public void addGameChangedEventListener(GamePhaseChangedListener listener) {
		eventListeners.add(GamePhaseChangedListener.class, listener);
	}

	public void setState(GamePhase state) {
		this.state = state;
		
		GamePhaseChangedEvent evt = new GamePhaseChangedEvent(this, this.state);
		
		Object[] listeners = eventListeners.getListenerList();
        
        for (int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == GamePhaseChangedListener.class) {
                ((GamePhaseChangedListener)listeners[i+1]).GamePhaseChanged(evt);
            }
        }
	}
	
	public boolean createCharacter(Character.Race race, Player player, Modifier bonus) {
		Character newChar = null; 
		
		switch(race)
		{
			case Elf:
				newChar = new Elf();
				break;
			case Human:
				newChar = new Human();
				break;
			case Orc: 
				newChar = new Orc();
				break;
			case Wizard:
				newChar = new Wizard();
				break;	
			
		}
		
		if (newChar == null || player == null) {
			return false;
		}
		
		newChar.setAttibutes(bonus.adjustAttrs(newChar.getAttributes()));
		
		addEntity(newChar, player);
	
		return true;
	}
	
	public void addEntity(PlayableEntity c, Player p) {
		entities.put(c, p);
	}
	
	public void removeEntity(PlayableEntity c) {
		entities.remove(c);
	}
	
	private boolean hasAWinner() {
		HashSet<Player> set = new HashSet<Player>();
		for (Player player : entities.values()) {
			if (!set.contains(player)) {
				set.add(player);
			}
		}
		
		return set.size() == 1;
	}
	
	private void refillTurnQueue() {
		turnQueue.addAll(entities.keySet());
	}
	
	private PlayableEntity computeNextEntity() {
		PlayableEntity retent = null;
		
		// Let's start: the one with the most dexterity gets the turn
		for (PlayableEntity ent : turnQueue) {
			if (ent instanceof Fighter) {
				if (retent != null) {
					if (((Fighter)ent).getDexterity() > ((Fighter)retent).getDexterity()) {
						retent = ent;
					}
				} else {
					// First insert, then let's just add it
					retent = ent;
				}
			}
		}
		
		if (retent == null) {
			// Ok, we probably don't have any fighters. Let's just add the first in the list then
			retent = (PlayableEntity)(turnQueue.toArray()[0]);
		}
		
		return retent;
	}
	
	public void performNextTurn() {

		if (hasAWinner()) {
			setState(GamePhase.EndGame);
			return;
		}
		
		if (turnQueue.isEmpty()) {
			refillTurnQueue();
		}
		
		PlayableEntity entity = computeNextEntity();
		
		if (entity != null && !entity.isOnTurn()) {
			int token = generateToken();
			turnTokens.put(token, entity);

			entity.startNewTurn();

			entities.get(entity).handleTurn(entity, token);
		}

	}
	
	public void endTurn(int token) {
		if (turnTokens.containsKey(token)) {
			turnTokens.get(token).completeTurn();
			
			// Cleanup
			turnQueue.remove(turnTokens.get(token));
			turnTokens.remove(token);
			
			// Move forward
			performNextTurn();
		}
	}
	
	private Integer generateToken() {
		Random r = new Random();
		return r.nextInt(65532);
	}
}
