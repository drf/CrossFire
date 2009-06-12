package gameLogic;

import java.util.Map;

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
	
	public Game() {}
	
	public Game(AbstractChart chart) {
		this.chart = chart;
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
