package items;

import java.io.IOException;

import javax.imageio.ImageIO;

import gameLogic.Equipable;
import globals.BaseAttributes;

/**
 * Long Sword as defined in the game specifics
 * 
 * @author drf
 *
 */
public class LongSword extends Item implements Equipable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8096251589795062627L;

	/**
	 * Create new long sword
	 */
	public LongSword() {
		super(0, +20, -20, 0, 0, 0, 0, 0, 0, 0, 0);
		BaseAttributes minReq = new BaseAttributes();
		minReq.setStrength(65);
		setMinimumRequirements(minReq);
		setName("Long Sword");
		try {
			setImage(ImageIO.read(ClassLoader.getSystemResource("resources/Sword.GIF")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
