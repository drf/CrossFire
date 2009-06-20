package gameLogic;

import java.util.Map;

import javax.swing.event.EventListenerList;

import characters.Character;
import characters.Elf;
import characters.Human;
import characters.Orc;
import characters.Wizard;

import player.Player;

import gameChart.AbstractChart;
import globals.Modifier;
import globals.PlayableEntity;

public class Game {
	AbstractChart chart;
	Map<PlayableEntity, Player> entities;
	GamePhase state;
	private static Game instance = null;
	
	// Event Listeners
	EventListenerList eventListeners = new EventListenerList();

	public enum GamePhase {
		None,
		GameCreation,
		CharacterSetup,
		Turn,
		EndGame
	}
	
	protected Game() {}
	
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
	
	public void startGame() {
		while (entities.keySet().size() != 1) {
			for (PlayableEntity entity : entities.keySet()) {
				if (entity != null) {
					entities.get(entity).handleTurn(entity);
				}				
			}
		}
	}
}
