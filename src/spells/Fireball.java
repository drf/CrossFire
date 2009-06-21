package spells;

import gameLogic.Attackable;
import gameLogic.CanMagicAttack;

public class Fireball extends Spell {

	public Fireball() {
		super(30, 10, 1, "Fireball", "A ball of fire damages a target and nearby entities");
	}
	
	@Override
	public int computeDamage(CanMagicAttack caster, Attackable target,
			int rangeLevel) {
		return (int)((caster.getIntelligence() * 0.6 + caster.getMagicSkill() * 0.6) 
				     * (1 - rangeLevel * 0.5) + caster.getMagicDamageBonus());
	}

}
