/**
 * 
 */
package characters;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

/**
 * @author snagg
 *
 */
public class FighterTest {

	/**
	 * Test method for {@link characters.Fighter#randomAttributes(int, int, int)}.
	 */
	@Test
	public void testRandomAttributes() {
		Random r = new Random();
		int max = 200 + r.nextInt(300);
		int min = r.nextInt(200);
		int num = 1 + r.nextInt(5);
		int value = 0; 
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for(int i = 0; i < 25; i++) {
			ret = Fighter.randomAttributes(min, max, num);
			for(Integer in : ret) 
				value += in.intValue();
			if(value > 500 && value < 200 ) {
				fail("failed " +  value);
			}else
				value = 0;
		}
	}

}
