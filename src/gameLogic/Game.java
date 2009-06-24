package gameLogic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.event.EventListenerList;

import characters.Character;
import characters.Elf;
import characters.Fighter;
import characters.Human;
import characters.Orc;
import characters.Wizard;

import player.ComputerPlayer;
import player.HumanPlayer;
import player.Player;

import gameChart.AbstractChart;
import globals.Entity;
import globals.Modifier;
import globals.PlayableEntity;

public class Game implements EntityListener {
	private AbstractChart chart;
	/**
	 * @return the chart
	 */
	public AbstractChart getChart() {
		return chart;
	}

	/**
	 * @param chart the chart to set
	 */
	public void setChart(AbstractChart chart) {
		this.chart = chart;
	}

	private HashMap<PlayableEntity, Player> entities = new HashMap<PlayableEntity, Player>();
	private HashMap<PlayableEntity, ComputerPlayer> npcs = new HashMap<PlayableEntity, ComputerPlayer>();
	private GamePhase state;
	private static Game instance = null;
	private HashMap<Integer, PlayableEntity> turnTokens = new HashMap<Integer, PlayableEntity>();
	private HashSet<PlayableEntity> turnQueue = new HashSet<PlayableEntity>();
	private PlayableEntity onTurn = null;
	private Player winner = null;
	
	/**
	 * @return the onTurn
	 */
	public PlayableEntity getOnTurn() {
		return onTurn;
	}

	/**
	 * @return the winner
	 */
	public Player getWinner() {
		return winner;
	}

	// Event Listeners
	EventListenerList eventListeners = new EventListenerList();

	public enum GamePhase {
		None,
		GameCreation,
		SetupDone,
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
	
	public static void resetGame() {
		instance = null;
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
	
	public Player createNewPlayer(String name, boolean human) {
		Player p;
		
		if (human) {
			p = new HumanPlayer();			
		} else {
			p = new ComputerPlayer();
		}
		
		p.setName(name);
		
		return p;
	}
	
	public Character createCharacter(Character.Race race, Modifier bonus, String name) {
		Character newChar = null; 
		
		switch(race)
		{
			case Elf:
				newChar = new Elf(name);
				break;
			case Human:
				newChar = new Human(name);
				break;
			case Orc: 
				newChar = new Orc(name);
				break;
			case Wizard:
				newChar = new Wizard(name);
				break;	
			
		}
		
		if (newChar == null)
			return null;
		
		newChar.setAttibutes(bonus.adjustAttrs(newChar.getAttributes()));
		
	
		return newChar;

	}
	
	public boolean assignCharacter(Player player, Character character) {
		
		if (character == null || player == null) {
			return false;
		}
		
		addEntity(character, player);
		character.setPlayer(player);
	
		return true;
	}
	
	public boolean assignEntity(Player player, PlayableEntity character) {
		
		if (character == null || player == null) {
			return false;
		}
		
		if (entities.containsKey(character)) {
			entities.remove(character);
		}
		
		if (npcs.containsKey(character)) {
			npcs.remove(character);
		}
		
		addEntity(character, player);
		character.setPlayer(player);
	
		return true;
	}
	
	public boolean assignNPC(ComputerPlayer player, PlayableEntity npc) {
		
		if (npc == null || player == null) {
			return false;
		}
		
		if (entities.containsKey(npc)) {
			entities.remove(npc);
		}
		
		if (npcs.containsKey(npc)) {
			npcs.remove(npc);
		}
		
		npcs.put(npc, player);
		npc.addEntityEventListener(this);
		npc.setPlayer(player);
	
		return true;
	}
	
	private void addEntity(PlayableEntity c, Player p) {
		entities.put(c, p);
		c.addEntityEventListener(this);
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
		turnQueue.addAll(npcs.keySet());
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
			endGame();
			return;
		}
		
		if (turnQueue.isEmpty()) {
			refillTurnQueue();
		}
		
		onTurn = computeNextEntity();
		
		if (onTurn != null && !onTurn.isOnTurn() &&
		    (entities.containsKey(onTurn) || npcs.containsKey(onTurn))) {
			int token = generateToken();
			turnTokens.put(token, onTurn);

			onTurn.startNewTurn();

			if (entities.containsKey(onTurn)) {
				entities.get(onTurn).handleTurn(onTurn, token);
			} else {
				npcs.get(onTurn).handleTurn(onTurn, token);
			}
		} else {
			turnQueue.remove(onTurn);
			performNextTurn();
		}

	}
	
	public void endTurn(int token) {
		System.out.println("Ending turn");
		if (turnTokens.containsKey(token)) {
			turnTokens.get(token).completeTurn();
			
			// Cleanup
			turnQueue.remove(turnTokens.get(token));
			turnTokens.remove(token);
		
			System.out.println("Nexti");
			// Move forward
			performNextTurn();
		}
		
	}
	
	private Integer generateToken() {
		Random r = new Random();
		return r.nextInt(65532);
	}
	
	public Set<PlayableEntity> getEntities() {
		return entities.keySet();
	}
	
	public Set<PlayableEntity> getNPCS() {
		return npcs.keySet();
	}


	public void EntityEventOccurred(EntityEvent e) {
		if (e instanceof DeathEvent) {
			// Delete the entity
			if (entities.containsKey(e.getSource())) {
				chart.remove((Entity)(e.getSource()));
				entities.remove(e.getSource());
				
				if (onTurn.getPlayer() instanceof HumanPlayer) {
					((HumanPlayer)(onTurn.getPlayer())).skipTurn();
				}
				
				endGame();
			} else if (npcs.containsKey(e.getSource())) {
				chart.remove((Entity)(e.getSource()));
				npcs.remove(e.getSource());
			}
		}
	}
	
	private void endGame() {
		// Find the winner
		winner = (Player)(entities.values().toArray()[0]);
		setState(GamePhase.EndGame);
	}
}
