package spells;

import java.util.HashSet;

import gameLogic.Attackable;
import gameLogic.CanMagicAttack;

public class AncientKnowledge extends Spell {

	public AncientKnowledge() {
		super(70, 0, 0, "Ancient Knowledge", "Teaches you a new spell. Might fail");
		setDealsDamage(false);
	}

	@Override
	public int computeDamage(CanMagicAttack caster, Attackable target,
			int rangeLevel) {
		for (int i = 0; i < 150; i++) {
			Spell spell = SpellGenerator.generateCasualSpell();
			for (Spell sp : caster.getAvailableSpells()) {
				if (spell.getClass() == sp.getClass()) {
					// We already know this spell
					continue;
				}
			}
			
			// Ok, we do not know it. Let's learn it
			HashSet<Spell> newspells = caster.getAvailableSpells();
			newspells.add(spell);
			caster.setAvailableSpells(newspells);
			
			return 0;
		}
		
		return -1;
	}
}
