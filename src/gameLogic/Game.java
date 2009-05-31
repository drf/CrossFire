package gameLogic;

import java.util.Map;

import player.Player;

import gameChart.AbstractChart;

public class Game {
	AbstractChart chart;
	Map<Character, Player> characters;
	
	public Game() {}
	
	public Game(AbstractChart chart) {
		this.chart = chart;
	}
	
	public void addCharacter(Character c, Player p) {
		characters.put(c, p);
	}
	
	public void removeCharacter(Character c) {
		characters.remove(c);
	}
}
