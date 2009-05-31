package items;

import java.util.Random;

import gameLogic.Equipable;
import gameLogic.Pickable;

public class ItemGenerator {
	
	public static Equipable generateCasualEquipable() {
		// Add all available equipable
		try {
			Random r = new Random();
			Class<?> c = Equipable.class.getClasses()[r.nextInt(Equipable.class.getClasses().length)];
			Object obj = c.newInstance();
			if (obj instanceof Equipable) {
				return (Equipable)obj;
			} else {
				return null;
			}
		} catch (InstantiationException e) {
			return null;
		} catch (IllegalAccessException e) {
			return null;
		}
	}

	public static Consumable generateCasualConsumable() {
		// Add all available equipable
		try {
			Random r = new Random();
			Class<?> c = Consumable.class.getClasses()[r.nextInt(Consumable.class.getClasses().length)];
			Object obj = c.newInstance();
			if (obj instanceof Consumable) {
				return (Consumable)obj;
			} else {
				return null;
			}
		} catch (InstantiationException e) {
			return null;
		} catch (IllegalAccessException e) {
			return null;
		}
	}
	
	public static Pickable generateCasualPickable() {
		// Add all available equipable
		try {
			Random r = new Random();
			Class<?> c = Pickable.class.getClasses()[r.nextInt(Pickable.class.getClasses().length)];
			Object obj = c.newInstance();
			if (obj instanceof Pickable) {
				return (Pickable)obj;
			} else {
				return null;
			}
		} catch (InstantiationException e) {
			return null;
		} catch (IllegalAccessException e) {
			return null;
		}
	} 
}
