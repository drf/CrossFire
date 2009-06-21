package characters;

import java.io.IOException;

import javax.imageio.ImageIO;

import items.ItemGenerator;
import gameChart.Box;
import gameChart.BoxBusyException;
import gameLogic.Attackable;
import gameLogic.Equipable;
import globals.Entity;

/**
 * <b>Dragon</b> is a {@link Monster} that can only perform melee attacks, but
 * has an extremely high attack potential.
 * <p>
 * Just like {@link Monster}, is implemented to show the flexibility of the approach
 * 
 * @author Dario Freddi
 * @author Vincenzo Iozzo
 *
 */
public class Dragon extends Monster {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3947223500999381060L;

	public Dragon() {
		super(50, 80, 30, 0, 5, 60, 0);
		try {
			setImage(ImageIO.read(ClassLoader.getSystemResource("resources/dragon.gif")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void boxChanged(Box oldBox, Box newBox) {
	}

	
	public int getDamageReduction() {
		return 5;
	}

	/**
	 * Reimplemented from {@link Attackable}. Drops a random {@link Equipable}
	 */
	public void onDeath() {
		// Drop an item as a reward
		try {
			getBox().getChart().place((Entity)ItemGenerator.generateCasualEquipable(), getBox());
		} catch (BoxBusyException e) {
			
		}
	}

	
	public int getMeleeDamageBonus() {
		return 5;
	}

}
