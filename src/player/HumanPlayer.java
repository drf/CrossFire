package player;

import gameLogic.Game;
import globals.BaseAttributes;
import globals.PlayableEntity;
import characters.Character;
import characters.Elf;
import characters.Human;
import characters.Orc;
import characters.Wizard;
import characters.Character.Race;

/**
 * <b>HumanPlayer</b> is a subclass of {@link Player}. The main aim of this class is to provide a way to make a human handle multiple characters.  
 * @author	Dario Freddi
 * @author	Vincenzo Iozzo
 */

public class HumanPlayer extends Player {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2548924442744837336L;
	private int token;

	public HumanPlayer() {
	}
	
	/**
	 * This method creates a new {@link Character}�and adds it to the player list.
	 * 
	 * This method always returns immediately. 
	 *
	 * @param  race the kind of player we want, it can be Elf, Orc, Human or Wizard
	 * @return ch	the new {@link Character} added to the list
	 * 
	 */
	public Character createNewCharacter(Race race) {
		Character ch = null;
		switch (race) {
		case Elf:
			ch = new Elf();
			break;
		case Orc:
			ch = new Orc();
			break;
		case Human:
			ch = new Human();
			break;
		case Wizard:
			ch = new Wizard();
		default:
			break;
		}
		
		addNewPlayableEntity(ch);
		return ch;
	}
	
	/**
	 * This method first checks the presence of a given {@link Character} then it adds a bonus to it. 
	 * 
	 * This method always returns immediately. 
	 *
	 * @param  c the character who will get the bonus
	 * @param  bonus the attributes we will add as a bonus
	 * @return c	the {@link Character} with modified {@link BaseAttributes}
	 * @see BaseAttributes
	 * 
	 */
	public Character addInitialBonus(Character c, BaseAttributes bonus) {
		// Check first if the character is in our list
		if (!entities.contains(c)) {
			return null;
		}
		
		// Now, for each value add it
		c.setDexterity(c.getDexterity() + bonus.getDexterity());
		c.setHp(c.getHp() + bonus.getHp());
		c.setIntelligence(c.getIntelligence() + bonus.getIntelligence());
		c.setLuck(c.getLuck() + bonus.getLuck());
		c.setMagicSkill(c.getMagicSkill() + bonus.getMagicSkill());
		c.setStrength(c.getStrength() + bonus.getStrength());
		
		return c;
	}

	@Override
	public void handleTurn(PlayableEntity entity, int token) {
		this.token = token;
	}
	
	public void skipTurn() {
		Game.getInstance().endTurn(token);
	}
}
