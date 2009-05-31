package gameChart;

import java.util.HashSet;
import java.util.Random;

public class LandscapeGenerator {

	private static HashSet<Class<?>> items() {
		HashSet<Class<?>> retset = new HashSet<Class<?>>();
		
		retset.add(City.class);
		retset.add(Hill.class);
		retset.add(Plain.class);
		
		return retset;
	}
	
	public static Box generateRandomLandscape() {
		HashSet<Box> items = new HashSet<Box>();
		
		for (Class<?> type : items()) {
			try {
				items.add((Box)type.newInstance());
			} catch (InstantiationException e) {

			} catch (IllegalAccessException e) {

			} catch (ClassCastException e) {
				
			}
		}
		
		Random r = new Random();
		return (Box) items.toArray()[r.nextInt(items.size())];
	}

}
