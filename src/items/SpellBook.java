package items;

import java.io.IOException;
import java.util.HashSet;

import javax.imageio.ImageIO;

import spells.Spell;
import spells.SpellGenerator;
import gameLogic.CanMagicAttack;
import gameLogic.CanPick;
import gameLogic.Consumable;

public class SpellBook extends Item implements Consumable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2906582863509321014L;
	private Spell spell = SpellGenerator.generateCasualSpell();

	public SpellBook() {
		super(0,0,0,0,0,0,0,0,0,0,0);
		setName("SpellBook of " + spell.getName());
		
		try {
			setImage(ImageIO.read(ClassLoader.getSystemResource("resources/spellbook.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see items.Item#onPick(gameLogic.CanPick)
	 */
	@Override
	public void onPick(CanPick picker) {
		if (picker instanceof CanMagicAttack) {
			CanMagicAttack caster = (CanMagicAttack)picker;
			// Let's learn a new spell!			
			for (Spell sp : caster.getAvailableSpells()) {
				if (spell.getClass() == sp.getClass()) {
					// Ah, we already know it. Whatever
					return;
				}
			}
			
			// Let's expand our knowledge
			HashSet<Spell> newspells = caster.getAvailableSpells();
			newspells.add(spell);
			caster.setAvailableSpells(newspells);
		} else {
			// What a waste...
			return;
		}
	}
}
