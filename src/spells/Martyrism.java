package spells;

import characters.Fighter;
import gameLogic.Attackable;
import gameLogic.CanMagicAttack;

public class Martyrism extends Spell {

	public Martyrism() {
		super(0, 100, 0, "Martyrism", "Sacrifices yourself to transfer your strength to an ally, making him almost invincible");
		setDealsDamage(false);
	}

	@Override
	public int computeDamage(CanMagicAttack caster, Attackable target,
			int rangeLevel) {
		Fighter t = (Fighter)target;
		Fighter c = (Fighter)caster;
		t.setHp(t.getHp() + c.getHp() + (int)((caster.getMagicSkill() + caster.getIntelligence()) * 0.5));
		t.setMp(t.getMp() + c.getMp() + (int)((caster.getMagicSkill() + caster.getIntelligence()) * 0.5));
		t.setDexterity(t.getDexterity() + c.getDexterity() + (int)((caster.getMagicSkill() + caster.getIntelligence()) * 0.2));
		t.setIntelligence(t.getIntelligence() + c.getIntelligence() + (int)((caster.getMagicSkill() + caster.getIntelligence()) * 0.2));
		t.setLuck(t.getLuck() + c.getLuck() + (int)((caster.getMagicSkill() + caster.getIntelligence()) * 0.2));
		t.setMagicSkill(t.getMagicSkill() + c.getMagicSkill() + (int)((caster.getMagicSkill() + caster.getIntelligence()) * 0.2));
		t.setStrength(t.getStrength() + c.getStrength() + (int)((caster.getMagicSkill() + caster.getIntelligence()) * 0.2));
		c.setHp(0);
		c.onDeath();
		return 0;
	}

}
