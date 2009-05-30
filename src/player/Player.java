package player;

import globals.BaseAttributes;

import java.util.ArrayList;

import characters.Character;
import characters.Elf;
import characters.Human;
import characters.Orc;
import characters.Wizard;
import characters.Character.Race;

public class Player {
	String name;
	ArrayList<Character> characters;
	
	public Player() {}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
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
		
		characters.add(ch);
		return ch;
	}
	
	public Character addInitialBonus(Character c, BaseAttributes bonus) {
		// Check first if the character is in our list
		if (!characters.contains(c)) {
			return null;
		}
		
		// Now, for each value, check if it's actually valid, and in case add it
		if (bonus.getDexterity() != -9999) {
			c.setDexterity(c.getDexterity() + bonus.getDexterity());
		}
		if (bonus.getHp() != -9999) {
			c.setHp(c.getHp() + bonus.getHp());
		}
		if (bonus.getIntelligence() != -9999) {
			c.setIntelligence(c.getIntelligence() + bonus.getIntelligence());
		}
		if (bonus.getLuck() != -9999) {
			c.setLuck(c.getLuck() + bonus.getLuck());
		}
		if (bonus.getMagicSkill() != -9999) {
			c.setMagicSkill(c.getMagicSkill() + bonus.getMagicSkill());
		}
		if (bonus.getStrength() != -9999) {
			c.setStrength(c.getStrength() + bonus.getStrength());
		}
		
		return c;
	}
	
}
