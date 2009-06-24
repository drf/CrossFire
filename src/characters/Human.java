package characters;

import gameLogic.CanMagicAttack;
import gameLogic.CanRangedAttack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.imageio.ImageIO;

import spells.AuraBolt;
import spells.Spell;

/**
 * <b>Human</b> is one of {@link Character}'s races. It has balanced attributes
 * 
 * @author Dario Freddi
 * @author Vincenzo Iozzo
 *
 */
public class Human extends Character implements CanMagicAttack, CanRangedAttack {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8123383954498179845L;
	
	private HashSet<Spell> spells = new HashSet<Spell>();

	public Human(String name) {
		super();
		setName(name);
		ArrayList<Integer> attrs = Character.randomAttributes(0, 300, 5);
		this.setStrength(attrs.get(0));
		this.setDexterity(attrs.get(1));
		this.setIntelligence(attrs.get(2));
		this.setLuck(attrs.get(3));
		this.setMagicSkill(attrs.get(4));		
		
		spells.add(new AuraBolt());
		
		try {
			setImage(ImageIO.read(ClassLoader.getSystemResource("resources/umano.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public HashSet<Spell> getAvailableSpells() {
		return spells;
	}
	
	public void setAvailableSpells(HashSet<Spell> spells) {
		this.spells = spells;
	}
}
