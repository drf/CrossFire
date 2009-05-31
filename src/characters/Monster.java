package characters;

import gameLogic.Attackable;
import gameLogic.CanMeleeAttack;
import gameLogic.Movable;

public abstract class Monster extends Fighter implements Attackable,
		CanMeleeAttack, Movable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5329358492380596495L;

	public Monster() {
		// TODO Auto-generated constructor stub
	}

	public Monster(int intelligence, int strength, int dexterity,
			int magicskill, int luck, int HP) {
		super(intelligence, strength, dexterity, magicskill, luck, HP);
		// TODO Auto-generated constructor stub
	}
}
