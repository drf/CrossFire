package characters;

import gameLogic.CanMagicAttack;
import gameLogic.CanRangedAttack;

import java.io.IOException;
import java.util.HashSet;

import javax.imageio.ImageIO;

import spells.AncientKnowledge;
import spells.Apocalypse;
import spells.AuraBolt;
import spells.Bless;
import spells.DarkGaze;
import spells.DarkPrison;
import spells.DeathTouch;
import spells.DivineIntervention;
import spells.Fireball;
import spells.Heal;
import spells.Implosion;
import spells.Martyrism;
import spells.Spell;
import spells.Teleport;
import spells.UnholySacrifice;

public class God extends Character implements CanRangedAttack, CanMagicAttack {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8879382461545119129L;
	private HashSet<Spell> spells = new HashSet<Spell>();

	public God() {
		super(1000,1000,1000,1000,1000,1000,1000);
		
		spells.add(new Heal());
		spells.add(new AuraBolt());
		spells.add(new UnholySacrifice());
		spells.add(new AncientKnowledge());
		spells.add(new DivineIntervention());
		spells.add(new DarkGaze());
		spells.add(new Apocalypse());
		spells.add(new Bless());
		spells.add(new DarkPrison());
		spells.add(new Fireball());
		spells.add(new Implosion());
		spells.add(new Teleport());
		spells.add(new DeathTouch());
		spells.add(new Martyrism());
		
		setName("God");
		
		try {
			setImage(ImageIO.read(ClassLoader.getSystemResource("resources/golem.gif")));
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
