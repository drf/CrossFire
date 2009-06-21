package characters;

import java.awt.Image;
import java.util.HashSet;

import spells.AuraBolt;
import spells.Fireball;
import spells.Heal;
import spells.Implosion;
import spells.Spell;

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

	public Wizard() {
		super();
		
		this.setLuck(Character.randomAttributes(50, 100 + 1, 1).get(0));
		this.setIntelligence(Character.randomAttributes(90, 100 + 1, 1).get(0));
		this.setStrength(Character.randomAttributes(0, 20 + 1, 1).get(0));
		this.setMagicSkill(Character.randomAttributes(80, 100 + 1, 1).get(0));
		
		spells.add(new Heal());
		spells.add(new AuraBolt());
		spells.add(new Implosion());
		spells.add(new Fireball());
	}

	public HashSet<Spell> getAvailableSpells() {
		return spells;
	}

	public void setAvailableSpells(HashSet<Spell> spells) {
		this.spells = spells;
	}
	
	
}
