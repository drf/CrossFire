package characters;

import gameChart.Box;
import gameLogic.CanMagicAttack;
import gameLogic.CanRangedAttack;

public class Elf extends Character implements CanRangedAttack, CanMagicAttack {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -566722519869275030L;

	public Elf() {
		super();
		
		this.setLuck(Character.randomAttributes(60, 100 + 1, 1).get(0));
		this.setIntelligence(Character.randomAttributes(70, 100 + 1, 1).get(0));
		this.setStrength(Character.randomAttributes(0, 50 + 1, 1).get(0));
		this.setMagicSkill(Character.randomAttributes(50 - 1, 80, 1).get(0));
	}
}
