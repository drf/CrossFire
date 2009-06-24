package characters;

import java.io.IOException;
import java.util.HashSet;

import javax.imageio.ImageIO;

import spells.AuraBolt;
import spells.Heal;
import spells.Spell;
import gameLogic.CanMagicAttack;
import gameLogic.CanRangedAttack;

/**
 * <b>Elf</b> is one of {@link Character}'s races. It has strong luck and intelligence
 * 
 * @author Dario Freddi
 * @author Vincenzo Iozzo
 *
 */
public class Elf extends Character implements CanRangedAttack, CanMagicAttack {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -566722519869275030L;
	
	private HashSet<Spell> spells = new HashSet<Spell>();

	public Elf(String name) {
		super();
		setName(name);
		
		this.setLuck(randomAttribute(60, 100 + 1));
		this.setIntelligence(randomAttribute(70, 100));
		this.setStrength(randomAttribute(0, 50 + 1));
		this.setMagicSkill(randomAttribute(50 - 1, 80 -1));
		
		spells.add(new Heal());
		spells.add(new AuraBolt());
		
		try {
			setImage(ImageIO.read(ClassLoader.getSystemResource("resources/elfo.png")));
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
