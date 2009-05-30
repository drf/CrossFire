package characters;

import gameLogic.CanRangedAttack;

import java.util.ArrayList;

public class Orc extends Character implements CanRangedAttack {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2392388529182998813L;

	public Orc() {
		super();
		
		ArrayList<Integer> attrs;
		attrs = Character.randomAttributes(80, 200 + 1, 2);
		this.setStrength(attrs.get(0));
		this.setDexterity(attrs.get(1));
		attrs = Character.randomAttributes(0, 50 + 1, 2);
		this.setLuck(attrs.get(0));
		this.setIntelligence(attrs.get(1));
	}
}
