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

	public Elf() {
		super();
		
		this.setLuck(Character.randomAttributes(60, 100 + 1, 1).get(0));
		this.setIntelligence(Character.randomAttributes(70, 100 + 1, 1).get(0));
		this.setStrength(Character.randomAttributes(0, 50 + 1, 1).get(0));
		this.setMagicSkill(Character.randomAttributes(50 - 1, 80, 1).get(0));
		
		spells.add(new Heal());
		spells.add(new AuraBolt());
		
		try {
			setImage(ImageIO.read(ClassLoader.getSystemResource("resources/hydra.gif")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public HashSet<Spell> getAvailableSpells() {
		return spells;
	}
	
	@Override
	public void setAvailableSpells(HashSet<Spell> spells) {
		this.spells = spells;
	}
}
