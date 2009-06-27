package gameLogic;

import items.ItemGenerator;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Random;
import java.util.Set;

import javax.swing.event.EventListenerList;

import characters.Character;
import characters.Dragon;
import characters.Elf;
import characters.Fighter;
import characters.God;
import characters.Human;
import characters.Hydra;
import characters.Orc;
import characters.Wizard;

import player.ComputerPlayer;
import player.HumanPlayer;
import player.Player;

import gameChart.AbstractChart;
import gameChart.BidimensionalChart;
import globals.Entity;
import globals.Modifier;
import globals.PlayableEntity;

/**
 * Game is the main entry point for the game logic. It is a singleton class taking
 * care of everything to perform the game, including turn handling, players handling
 * and state
 * 
 * <p>Every interface implementing the CrossFire core should refer to Game as the main
 * entry point. A very minimal interface can be created just by interacting with the Game
 * instance
 * 
 * @author Dario Freddi
 * @author Vincenzo Iozzo
 *
 */
public class Game implements EntityListener {
	/**
	 * @uml.property  name="chart"
	 * @uml.associationEnd  
	 */
	private AbstractChart chart;
	/**
	 * @return  the chart
	 * @uml.property  name="chart"
	 */
	public AbstractChart getChart() {
		return chart;
	}

	/**
	 * @param chart  the chart to set
	 * @uml.property  name="chart"
	 */
	public void setChart(AbstractChart chart) {
		this.chart = chart;
	}

	/**
	 * @uml.property  name="entities"
	 */
	private Hashtable<PlayableEntity, Player> entities = new Hashtable<PlayableEntity, Player>();
	private Hashtable<PlayableEntity, ComputerPlayer> npcs = new Hashtable<PlayableEntity, ComputerPlayer>();
	/**
	 * @uml.property  name="state"
	 * @uml.associationEnd  
	 */
	private GamePhase state;
	/**
	 * @uml.property  name="instance"
	 * @uml.associationEnd  
	 */
	private static Game instance = null;
	private HashMap<Integer, PlayableEntity> turnTokens = new HashMap<Integer, PlayableEntity>();
	private HashSet<PlayableEntity> turnQueue = new HashSet<PlayableEntity>();
	/**
	 * @uml.property  name="onTurn"
	 * @uml.associationEnd  
	 */
	private PlayableEntity onTurn = null;
	/**
	 * @uml.property  name="winner"
	 * @uml.associationEnd  
	 */
	private Player winner = null;
	
	/**
	 * @return  the entity that is currently on turn
	 * @uml.property  name="onTurn"
	 */
	public PlayableEntity getOnTurn() {
		return onTurn;
	}

	/**
	 * @return  the winner, if one, otherwise null
	 * @uml.property  name="winner"
	 */
	public Player getWinner() {
		return winner;
	}

	// Event Listeners
	EventListenerList eventListeners = new EventListenerList();

	/**
	 * @author   drf
	 */
	public enum GamePhase {
		/**
		 * @uml.property  name="none"
		 * @uml.associationEnd  
		 */
		None,
		/**
		 * @uml.property  name="gameCreation"
		 * @uml.associationEnd  
		 */
		GameCreation,
		/**
		 * @uml.property  name="setupDone"
		 * @uml.associationEnd  
		 */
		SetupDone,
		/**
		 * @uml.property  name="turn"
		 * @uml.associationEnd  
		 */
		Turn,
		/**
		 * @uml.property  name="endGame"
		 * @uml.associationEnd  
		 */
		EndGame
	}
	
	private Game() {}
	
	/**
	 * @return the instance of the class
	 * @uml.property  name="instance"
	 */
	public static Game getInstance() {
		if (instance == null) {
			instance = new Game();
		}
		
		return instance;
	}
	
	/**
	 * Resets the game. WARNING: calling this function will actually start a
	 * brand new game and delete all the properties of the old one!!
	 */
	public static void resetGame() {
		instance = null;
	}
	
	/**
	 * @return
	 * @uml.property  name="state"
	 */
	public GamePhase getState() {
		return state;
	}
	
	public void addGameChangedEventListener(GamePhaseChangedListener listener) {
		eventListeners.add(GamePhaseChangedListener.class, listener);
	}

	/**
	 * Sets the new state of the game. This will trigger a GamePhaseChanged event
	 * that can be grabbed by the interface to update its view
	 * 
	 * @param state the new state of the game
	 * @uml.property  name="state"
	 */
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
	
	/**
	 * Creates and returns a new player. This is a convenience function to create a generic
	 * player object without dealing with player subclasses
	 * 
	 * @param name the name of the new player
	 * @param human whether the player will be controlled by the user or not
	 * @return a new {@link Player}
	 */
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
	
	/**
	 * Creates a random monster
	 * 
	 * @return a random monster
	 */
	public PlayableEntity createRandomMonster()  {
		Random r = new Random();
		int randomInt = r.nextInt(10);
		
		if (randomInt == 9) {
			return new God();
		} else if (randomInt >= 5) { 
			return new Dragon();
		} else {
			return new Hydra();
		}
		
	}
	
	/**
	 * Creates a new {@link Character} and returns it. This is a convenience function for
	 * creating {@link Character}s without dealing with its subclasses
	 * 
	 * @param race the race of the new character
	 * @param bonus the attribute bonus given on creation
	 * @param name the name of the character
	 * @return a new {@link Character} based on the given attributes
	 */
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
	
	/**
	 * Assigns and register a {@link PlayableEntity} to a {@link Player}. After this function
	 * has been called, the chosen {@link PlayableEntity} will be added to the game logic and
	 * loop
	 * 
	 * @param player the player the entity will belong to
	 * @param character the {@link PlayableEntity} to register
	 * @return whether the operation was successful or not
	 */
	public boolean assignCharacter(Player player, PlayableEntity character) {
		
		if (character == null || player == null) {
			return false;
		}
		
		addEntity(character, player);
		character.setPlayer(player);
	
		return true;
	}
	
	/**
	 * Assigns and register a {@link PlayableEntity} to a {@link Player}. After this function
	 * has been called, the chosen {@link PlayableEntity} will be added to the game logic and
	 * loop
	 * 
	 * @param player the player the entity will belong to
	 * @param character the {@link PlayableEntity} to register
	 * @return whether the operation was successful or not
	 */
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
	
	/**
	 * Assigns and register a {@link PlayableEntity} to a {@link ComputerPlayer}. After this function
	 * has been called, the chosen {@link PlayableEntity} will be added to the game logic and
	 * loop. Please note that this function is meant only for NPC characters
	 * 
	 * @param player the player the entity will belong to
	 * @param character the {@link PlayableEntity} to register
	 * @return whether the operation was successful or not
	 */
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
	
	/**
	 * Removes an entity from the game
	 * 
	 * @param c the entity to remove
	 */
	public void removeEntity(PlayableEntity c) {
		entities.remove(c);
	}
	
	/**
	 * Removes a player from the game. Every entity registered to him will
	 * be removed as well
	 * 
	 * @param p the {@link Player} to remove
	 */
	public void removePlayer(Player p){
		
		for(Enumeration e  = entities.keys(); e.hasMoreElements();){
			PlayableEntity c = (PlayableEntity) e.nextElement();
			if(entities.containsValue(p))
				removeEntity(c);
			}
		
		for(Enumeration e = npcs.keys(); e.hasMoreElements();) {
			PlayableEntity ch = (PlayableEntity)e.nextElement();
			if(npcs.containsValue(p))
				removeEntity(ch);
			}
	
	}	
	
	private void randomlyPlaceEntity(Entity ent) 
	{
	
		Random r = new Random(); 
		BidimensionalChart actualChart;
		int posY; 
		int posX; 
		
		if(chart != null)
			actualChart = (BidimensionalChart)chart;
		else
			return;
		
		while(true)
		{
			try {
				posY = r.nextInt(actualChart.getHeight());
				posX = r.nextInt(actualChart.getWidth());
				chart.place(ent, actualChart.getBoxAt(posX, posY));
				break;
			}
			catch (Exception e) {
				continue;
			}
		}


	}
	
	/**
	 * Randomly places on the chart a casual number of item depending on the chart's size
	 */
	public void randomlyPlaceItems() {
		Random r = new Random();
		BidimensionalChart actualChart;
		int totalItems;
		
		if(chart != null)
			actualChart = (BidimensionalChart)chart;
		else
			return;
		//we place at most X items, we use Height otherwise linear charts will end up full of items
		totalItems = actualChart.getHeight();
		
		for(int i = 0; i <= totalItems; i++) {
			switch(r.nextInt(4)) {
				case 0:
				case 1:
					randomlyPlaceEntity((Entity)ItemGenerator.generateCasualPickable());
					break;
				case 2:
					randomlyPlaceEntity((Entity)ItemGenerator.generateCasualConsumable());
					break;
				case 3:
					randomlyPlaceEntity((Entity)ItemGenerator.generateCasualEquipable());
					break;
			}
		}
		
		
	}
	
	/**
	 * Randomly places on the chart all the registered entities
	 */
	public void randomlyPlaceEntities()
	{
		
		for(Enumeration e  = entities.keys(); e.hasMoreElements();){
			PlayableEntity c = (PlayableEntity) e.nextElement();
			randomlyPlaceEntity(c);
			}
		
		for(Enumeration e = npcs.keys(); e.hasMoreElements();) {
			PlayableEntity ch = (PlayableEntity)e.nextElement();
			randomlyPlaceEntity(ch);
		}
			
	}
	
	/** 
	 * @return if the current game has a winner
	 */
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
	
	/**
	 * Main entry point for the turn logic. This function computes the next entity who will
	 * get the turn, and processes it.
	 */
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
	
	/**
	 * Ends a turn
	 * 
	 * @param token the turn token
	 */
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
	
	/**
	 * @return the registered entities in the game
	 * @uml.property  name="entities"
	 */
	public Set<PlayableEntity> getEntities() {
		return entities.keySet();
	}
	
	/**
	 * 
	 * @return the registered NPCs in the game
	 */
	public Set<PlayableEntity> getNPCS() {
		return npcs.keySet();
	}


	public void EntityEventOccurred(EntityEvent e) {
		if (e instanceof DeathEvent) {
			// Delete the entity
			if (entities.containsKey(e.getSource())) {
				chart.remove((Entity)(e.getSource()));
				entities.remove(e.getSource());
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
