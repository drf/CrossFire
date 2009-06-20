package spells;

import gameLogic.Attackable;
import gameLogic.CanMagicAttack;

public class Apocalypse extends Spell {

	public Apocalypse() {
		super(80, 1000, 2, "Apocalypse", "The ultimate spell. Deals a huge damage on a wide area");
	}
	
	@Override
	public int computeDamage(CanMagicAttack caster, Attackable target,
			int rangeLevel) {
		return (int)((caster.getIntelligence() * 0.7 + caster.getMagicSkill() * 0.8) 
			        * (1 - rangeLevel * 0.3) + caster.getMagicDamageBonus());
	}

}
