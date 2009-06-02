package items;

import java.util.HashSet;
import java.util.Random;

import gameLogic.Consumable;
import gameLogic.Equipable;
import gameLogic.Pickable;

/**
 * <b>ItemGenerator</b> is a set of static functions that generate casual items. 
 * Its internals are based upon {@link Class} properties.
 * 
 * @author drf
 *
 */
public class ItemGenerator {
	
	/**
	 * Internal to ItemGenerator
	 * 
	 * @return a list of the available items in the game
	 */
	private static HashSet<Class<?>> items() {
		HashSet<Class<?>> retset = new HashSet<Class<?>>();
		
		retset.add(Bow.class);
		retset.add(LongSword.class);
		retset.add(MagicStick.class);
		retset.add(Potion.class);
		retset.add(Shield.class);
		
		return retset;
	}
	
	/**
	 * Generate a casual {@link Equipable}
	 * 
	 * @return a random {@link Equipable}
	 */
	public static Equipable generateCasualEquipable() {
		HashSet<Equipable> items = new HashSet<Equipable>();
		
		for (Class<?> type : items()) {
			try {
				items.add((Equipable)type.newInstance());
			} catch (InstantiationException e) {

			} catch (IllegalAccessException e) {

			} catch (ClassCastException e) {
				
			}
		}
		
		Random r = new Random();
		return (Equipable) items.toArray()[r.nextInt(items.size())];
	}

	/**
	 * Generate a casual {@link Consumable}
	 * 
	 * @return a random {@link Consumable}
	 */
	public static Consumable generateCasualConsumable() {
		HashSet<Consumable> items = new HashSet<Consumable>();
		
		for (Class<?> type : items()) {
			try {
				items.add((Consumable)type.newInstance());
			} catch (InstantiationException e) {

			} catch (IllegalAccessException e) {

			} catch (ClassCastException e) {
				
			}
		}
		
		Random r = new Random();
		return (Consumable) items.toArray()[r.nextInt(items.size())];
	}
	
	/**
	 * Generate a casual {@link Pickable}
	 * 
	 * @return a a random {@link Pickable}
	 */
	public static Pickable generateCasualPickable() {
		HashSet<Pickable> items = new HashSet<Pickable>();
		
		for (Class<?> type : items()) {
			try {
				items.add((Pickable)type.newInstance());
			} catch (InstantiationException e) {

			} catch (IllegalAccessException e) {

			} catch (ClassCastException e) {
				
			}
		}
		
		Random r = new Random();
		return (Pickable) items.toArray()[r.nextInt(items.size())];
	} 
}
