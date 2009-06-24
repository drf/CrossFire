package items;

import java.io.IOException;

import javax.imageio.ImageIO;

import gameLogic.Equipable;

/**
 * Shield as defined in the game specifics
 * 
 * @author drf
 *
 */
public class Shield extends Item implements Equipable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3329552295419351743L;

	/**
	 * Create a new shield
	 */
	public Shield() {
		super(0, 0, 0, -10, 0, 0, 0, 0, 0, 0, 10);
		setName("Shield");
		
		try {
			setImage(ImageIO.read(ClassLoader.getSystemResource("resources/shieldback.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
