package characters;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class HumanTest {
	
	Set<Human> humans = new HashSet<Human>();

	@Before
	public void setUp() throws Exception {
		for (int i = 0; i < 100; i++) {
			humans.add(new Human("test"));
		}
	}

	@Test
	public void testIsValid() {
		for (Human h : humans) {
			if (!h.isValid()) {
				int i = h.getStrength()+h.getDexterity()+h.getIntelligence()+h.getLuck()+h.getMagicSkill();
				fail("Test failed, sum is " + i);
			}
		}
	}

}
