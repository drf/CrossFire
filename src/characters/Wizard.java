package characters;

import java.io.IOException;
import java.util.HashSet;

import javax.imageio.ImageIO;

import spells.AuraBolt;
import spells.DarkGaze;
import spells.DivineIntervention;
import spells.Fireball;
import spells.Heal;
import spells.Implosion;
import spells.Spell;
import spells.UnholySacrifice;

import gameLogic.CanMagicAttack;
import gameLogic.CanRangedAttack;

/**
 * <b>Elf</b> is one of {@link Character}'s races. It has strong magic skill and intelligence
 * 
 * @author Dario Freddi
 * @author Vincenzo Iozzo
 *
 */
public class Wizard extends Character implements CanMagicAttack, CanRangedAttack {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5254710813109154059L;
	private HashSet<Spell> spells = new HashSet<Spell>();

	public Wizard(String name) {
		super();
		setName(name);
		this.setLuck(randomAttribute(50, 100 + 1));
		this.setIntelligence(randomAttribute(90, 100 + 1));
		this.setStrength(randomAttribute(0, 20 + 1));
		this.setMagicSkill(randomAttribute(80, 100 + 1));
		
		spells.add(new Heal());
		spells.add(new AuraBolt());
		spells.add(new Implosion());
		spells.add(new Fireball());
		spells.add(new UnholySacrifice());
		spells.add(new DivineIntervention());
		
		try {
			setImage(ImageIO.read(ClassLoader.getSystemResource("resources/angel.gif")));
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
