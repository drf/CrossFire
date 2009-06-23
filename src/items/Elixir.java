package items;

import gameLogic.Consumable;

public class Elixir extends Item implements Consumable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1077678864715824105L;

	public Elixir() {
		super(0, 0, 0, 0, 0, 0, +15, 0, 0, 0, 0);
		setName("Magic Elixir");
	}
}
