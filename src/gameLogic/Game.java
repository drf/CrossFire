package gameLogic;

import items.ItemGenerator;

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
import gameChart.BidimensionalChart;
import globals.Entity;
import globals.Modifier;
import globals.PlayableEntity;

/**
 * @author  drf
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
	private HashMap<PlayableEntity, Player> entities = new HashMap<PlayableEntity, Player>();
	private HashMap<PlayableEntity, ComputerPlayer> npcs = new HashMap<PlayableEntity, ComputerPlayer>();
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
	 * @return  the onTurn
	 * @uml.property  name="onTurn"
	 */
	public PlayableEntity getOnTurn() {
		return onTurn;
	}

	/**
	 * @return  the winner
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
	 * @return
	 * @uml.property  name="instance"
	 */
	public static Game getInstance() {
		if (instance == null) {
			instance = new Game();
		}
		
		return instance;
	}
	
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
	 * @param state
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
	
	public boolean assignCharacter(Player player, PlayableEntity character) {
		
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
	public void removePlayer(Player p){
		for(PlayableEntity c: entities.keySet()){
			entities.containsValue(p);
			removeEntity(c);
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
	
	public void randomlyPlaceItems() {
		Random r = new Random();
		BidimensionalChart actualChart;
		int totalItems;
		
		if(chart != null)
			actualChart = (BidimensionalChart)chart;
		else
			return;
		//we place at most X items
		totalItems = actualChart.getWidth();
		
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
	
	public void randomlyPlaceEntities()
	{

		for(PlayableEntity p : entities.keySet()) 
			randomlyPlaceEntity(p);
		
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
	
	/**
	 * @return
	 * @uml.property  name="entities"
	 */
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
