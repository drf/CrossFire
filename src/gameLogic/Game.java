package gameLogic;

import java.util.Map;

import player.Player;

import gameChart.AbstractChart;
import globals.PlayableEntity;

public class Game {
	AbstractChart chart;
	Map<PlayableEntity, Player> entities;
	
	public Game() {}
	
	public Game(AbstractChart chart) {
		this.chart = chart;
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
