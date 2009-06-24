package characters;

import gameLogic.CanRangedAttack;

import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * <b>Elf</b> is one of {@link Character}'s races. It has a really high strength,
 * however it lacks magical attacks
 * 
 * @author Dario Freddi
 * @author Vincenzo Iozzo
 *
 */
public class Orc extends Character implements CanRangedAttack {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2392388529182998813L;

	public Orc(String name) {
		super();
		setName(name);
		ArrayList<Integer> attrs;
		attrs = Character.randomAttributes(80, 200 + 1, 2);
		this.setStrength(attrs.get(0));
		this.setDexterity(attrs.get(1));
		attrs = Character.randomAttributes(0, 50 + 1, 2);
		this.setLuck(attrs.get(0));
		this.setIntelligence(attrs.get(1));
		
		try {
			setImage(ImageIO.read(ClassLoader.getSystemResource("resources/orc.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
