package characters;

import java.io.IOException;

import javax.imageio.ImageIO;

import gameChart.BoxBusyException;
import globals.Entity;
import items.ItemGenerator;

public class Hydra extends Monster {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5894920156747207228L;

	public Hydra() {
		super(50, 60, 15, 5, 100, 100, 0);
		try {
			setImage(ImageIO.read(ClassLoader.getSystemResource("resources/hydra.gif")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setName("Hydra");
	}

	@Override
	public int getDamageReduction() {
		return 5;
	}

	@Override
	public int getMeleeDamageBonus() {
		return 0;
	}
	
	public void onDeath() {
		super.onDeath();
		// Drop an item as a reward
		try {
			getBox().getChart().place((Entity)ItemGenerator.generateCasualPickable(), getBox());
		} catch (BoxBusyException e) {
			
		}
	}

}
