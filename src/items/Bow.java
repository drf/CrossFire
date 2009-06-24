package items;

import java.io.IOException;

import javax.imageio.ImageIO;

import globals.BaseAttributes;

/**
 * Bow as defined in the game specifics
 * 
 * @author drf
 *
 */
public class Bow extends Item {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7416298710665666835L;

	/**
	 * Creates a new bow according to specifics
	 */
	public Bow() {
		super(0, 0, 0, 0, 0, 0, 0, 0, 0, +10, 0);
		BaseAttributes min = new BaseAttributes();
		min.setLuck(50);
		min.setDexterity(50);
		setMinimumRequirements(min);
		
		try {
			setImage(ImageIO.read(ClassLoader.getSystemResource("resources/crossbow.gif")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
