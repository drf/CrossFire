package spells;

import gameLogic.Attackable;
import gameLogic.CanMagicAttack;

public class UnholySacrifice extends Spell {

	public UnholySacrifice() {
		super(0, 0, 0, "Unholy Sacrifice", "Converts 10 of your HP into MP");
		setDealsDamage(false);
	}
	
	@Override
	public int computeDamage(CanMagicAttack caster, Attackable target,
			int rangeLevel) {
		target.setHp(target.getHp() - 10);
		caster.setMp(caster.getMp() + 10 + (int)((caster.getIntelligence() + 
												 caster.getMagicSkill() +
												 caster.getMagicDamageBonus())
												 * 0.10));
		return 10;
	}

	/* (non-Javadoc)
	 * @see spells.Spell#fulfillsSpecialRequirements(gameLogic.CanMagicAttack, gameLogic.Attackable)
	 */
	@Override
	public boolean fulfillsSpecialRequirements(CanMagicAttack caster,
			Attackable target) {
		// TODO Auto-generated method stub
		return caster == target;
	}

}
