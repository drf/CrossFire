package spells;

import java.util.HashSet;
import java.util.Random;

/**
 * <b>SpellGenerator</b> is a set of static functions that generate casual spell. 
 * Its internals are based upon {@link Class} properties.
 * 
 * @author drf
 *
 */
public class SpellGenerator {
	
	/**
	 * Internal to SpellGenerator
	 * 
	 * @return a list of the available spells in the game
	 */
	private static HashSet<Class<?>> spells() {
		HashSet<Class<?>> retset = new HashSet<Class<?>>();
		
		retset.add(Apocalypse.class);
		retset.add(AuraBolt.class);
		retset.add(DivineIntervention.class);
		retset.add(Fireball.class);
		retset.add(Heal.class);
		retset.add(Implosion.class);
		retset.add(DarkPrison.class);
		retset.add(DarkGaze.class);
		retset.add(Bless.class);
		retset.add(UnholySacrifice.class);
		
		return retset;
	}
	
	/**
	 * Generate a casual {@link Spell}
	 * 
	 * @return a random {@link Spell}
	 */
	public static Spell generateCasualSpell() {
		HashSet<Spell> spells = new HashSet<Spell>();
		
		for (Class<?> type : spells()) {
			try {
				spells.add((Spell)type.newInstance());
			} catch (InstantiationException e) {

			} catch (IllegalAccessException e) {

			} catch (ClassCastException e) {
				
			}
		}
		
		Random r = new Random();
		return (Spell) spells.toArray()[r.nextInt(spells.size())];
	}
	
}
