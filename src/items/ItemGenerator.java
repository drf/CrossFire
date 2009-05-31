package items;

import java.util.HashSet;
import java.util.Random;

import gameLogic.Equipable;
import gameLogic.Pickable;

public class ItemGenerator {
	
	private static HashSet<Class<?>> items() {
		HashSet<Class<?>> retset = new HashSet<Class<?>>();
		
		retset.add(Bow.class);
		retset.add(LongSword.class);
		retset.add(MagicStick.class);
		retset.add(Potion.class);
		retset.add(Shield.class);
		
		return retset;
	}
	
	public static Equipable generateCasualEquipable() {
		HashSet<Equipable> items = new HashSet<Equipable>();
		
		for (Class<?> type : items()) {
			for (Class<?> item : type.getInterfaces()) {
				if (item == Equipable.class) {
					try {
						items.add((Equipable)item.newInstance());
					} catch (InstantiationException e) {
						
					} catch (IllegalAccessException e) {
						
					}
				}
			}
		}
		
		Random r = new Random();
		return (Equipable) items.toArray()[r.nextInt(items.size())];
	}

	public static Consumable generateCasualConsumable() {
		HashSet<Consumable> items = new HashSet<Consumable>();
		
		for (Class<?> type : items()) {
			for (Class<?> item : type.getInterfaces()) {
				if (item == Consumable.class) {
					try {
						items.add((Consumable)item.newInstance());
					} catch (InstantiationException e) {
						
					} catch (IllegalAccessException e) {
						
					}
				}
			}
		}
		
		Random r = new Random();
		return (Consumable) items.toArray()[r.nextInt(items.size())];
	}
	
	public static Pickable generateCasualPickable() {
		HashSet<Pickable> items = new HashSet<Pickable>();
		
		for (Class<?> type : items()) {
			try {
				items.add((Pickable)type.newInstance());
			} catch (InstantiationException e) {

			} catch (IllegalAccessException e) {

			}
		}
		
		Random r = new Random();
		return (Pickable) items.toArray()[r.nextInt(items.size())];
	} 
}
