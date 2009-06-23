package characters;

import gameChart.Box;
import gameLogic.Attackable;
import gameLogic.CanMeleeAttack;
import gameLogic.Movable;

/**
 * <b>Monster</b> is a (generally hostile) NPC in the game, that usually gives a reward 
 * upon being killed.
 * <p>
 * Although not required by the specifics of the game, is implemented (as can be seen, in
 * really few lines) to demonstrate the flexibility of the chosen interface/subclass
 * approach.
 * 
 * @see Fighter
 * 
 * @author Dario Freddi
 * @author Vincenzo Iozzo
 *
 */
public abstract class Monster extends Fighter implements Attackable,
		CanMeleeAttack, Movable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5329358492380596495L;

	/**
	 * Default constructor, create a monster with random attributes
	 * 
	 * @see Fighter.Fighter()
	 */
	public Monster() {
		super();
	}

	/**
	 * Creates a new monster with the given attributes
	 * 
	 * @param intelligence the monster's intelligence
	 * @param strength the monster's strength
	 * @param dexterity the monster's dexterity
	 * @param magicskill the monster's magic skill
	 * @param luck the monster's luck
	 * @param HP the monster's health points
	 */
	public Monster(int intelligence, int strength, int dexterity,
			int magicskill, int luck, int HP, int MP) {
		super(intelligence, strength, dexterity, magicskill, luck, HP, MP);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see gameLogic.Movable#boxChanged(gameChart.Box, gameChart.Box)
	 */
	@Override
	public void boxChanged(Box oldBox, Box newBox) {
	}
	
	
}
