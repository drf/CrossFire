package gameChart;

import java.util.Random;


/**
 * <b>LandscapeGenerator</b> is used to randomly select a landscape from a given set. 
 * @author	Dario Freddi
 * @author	Vincenzo Iozzo
 */
public class LandscapeGenerator {

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
	public static Box generateRandomLandscape(AbstractChart chart) {
		Random r = new Random();
		switch (r.nextInt(3)) {
		case 0:
			return new City(chart);
		case 1:
			return new Hill(chart);
		case 2:
			return new Plain(chart);
		default:
			return null;
		}
	}

}
