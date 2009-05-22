package characters;

import java.util.ArrayList;

public class Human extends Character {
	
	public Human() {
		super();
		ArrayList<Integer> attrs = Character.randomAttributes(0, 300, 5);
		this.setStrength(attrs.get(0));
		this.setDexterity(attrs.get(1));
		this.setIntelligence(attrs.get(2));
		this.setLuck(attrs.get(3));
		this.setMagicSkill(attrs.get(4));		
	}
}
