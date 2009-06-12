package gameChart;

import java.util.HashSet;
import java.util.Random;


/**
 * <b>LandscapeGenerator</b> is used to randomly select a landscape from a given set. 
 * @author	Dario Freddi
 * @author	Vincenzo Iozzo
 */
public class LandscapeGenerator {

	/**
	 * This method populates an array with all the possible landscapes. 
	 * This method always returns immediately. 
	 *
	 * @return an HashSet will all the landscape types
	 * @see City
	 * @see Hill
	 * @see Plain
	 * 
	 */
	private static HashSet<Class<?>> items() {
		HashSet<Class<?>> retset = new HashSet<Class<?>>();
		
		retset.add(City.class);
		retset.add(Hill.class);
		retset.add(Plain.class);
		
		return retset;
	}
	
	/**
	 * This method chooses a random landscape taken from the array. 
	 *
	 * @return an instance of a random landscape
	 * @exception InstantiationException if we were unable to instantiate the object
	 * @exception IllegalAccess if no landscape is found
	 * @exception ClassCast if we cannot cast the landscape to the generic class Box
	 * @see City
	 * @see Hill
	 * @see Plain
	 * @see Box
	 * 
	 */
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
