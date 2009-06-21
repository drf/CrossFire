package spells;

import characters.Fighter;
import gameLogic.Attackable;
import gameLogic.CanMagicAttack;

public class DarkPrison extends Spell {

	public DarkPrison() {
		super(35, 5, 0, "Dark Prison", "Lowers an enemy's attributes");
		setDealsDamage(false);
	}
	
	@Override
	public int computeDamage(CanMagicAttack caster, Attackable target,
			int rangeLevel) {
		Fighter enemy = ((Fighter)target);
		enemy.setDexterity(enemy.getDexterity() - (int)((caster.getIntelligence() + caster.getMagicSkill()) * 0.1));
		enemy.setStrength(enemy.getStrength() - (int)((caster.getIntelligence() + caster.getMagicSkill()) * 0.1));
		enemy.setIntelligence(enemy.getIntelligence() - (int)((caster.getIntelligence() + caster.getMagicSkill()) * 0.1));
		enemy.setMagicSkill(enemy.getMagicSkill() - (int)((caster.getIntelligence() + caster.getMagicSkill()) * 0.1));
		return 0;
	}
	
	@Override
	public boolean fulfillsSpecialRequirements(CanMagicAttack caster,
			Attackable target) {
		return target instanceof Fighter;
	}

}
