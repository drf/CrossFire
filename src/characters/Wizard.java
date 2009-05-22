package characters;

public class Wizard extends Character {

	public Wizard() {
		super();
		
		this.setLuck(Character.randomAttributes(50, 100 + 1, 1).get(0));
		this.setIntelligence(Character.randomAttributes(90, 100 + 1, 1).get(0));
		this.setStrength(Character.randomAttributes(0, 20 + 1, 1).get(0));
		this.setMagicSkill(Character.randomAttributes(80, 100 + 1, 1).get(0));
	}
}
