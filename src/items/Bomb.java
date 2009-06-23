package items;

import gameChart.Box;
import gameLogic.Attackable;
import gameLogic.CanAttack;
import gameLogic.CombatHandler;
import globals.Entity;

/**
 * <b>Bomb</b> is an item that can be attacked, and upon death damages all the 
 * {@link Attackable} in its range.
 * <p>
 * Although not requested, it's implemented to show the flexibility of our approach
 * 
 * @author drf
 *
 */
public class Bomb extends globals.Entity implements Attackable, CanAttack  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2855052652888294440L;
	int hp;
	
	/**
	 * Create a new bomb
	 */
	public Bomb() {
		hp = 10;
		setName("Bomb");
	}
	
	/**
	 * @return the dexterity of the bomb
	 */
	public int getDexterity() {
		return 0;
	}

	/**
	 * @return the health points of the bomb
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * @return the luck of the bomb
	 */
	public int getLuck() {
		return 0;
	}

	/**
	 * @return the strength of the bomb
	 */
	public int getStrength() {
		return 10;
	}

	/**
	 * Called when the bomb dies (usually after the first attack, if the attacker is not
	 * particularly weak). Deals 10 damages to the units in the adjacent boxes and 20 to the
	 * unit in its own box
	 */
	public void onDeath() {
		// Deal 10 damage to each unity in the adjacent boxes
		for (Box box : getBox().getAdjacentBoxes()) {
			for (Entity ent : box.getChart().getEntitiesOn(box)) {
				if (ent instanceof Attackable) {
					CombatHandler.getInstance().fixedAttack(this, (Attackable)ent, 10);
				}
			}
		}
		for (Entity ent : getBox().getChart().getEntitiesOn(getBox())) {
			if (ent instanceof Attackable && ent != this) {
				CombatHandler.getInstance().fixedAttack(this, (Attackable)ent, 20);
			}
		}
		getBox().getChart().remove(this);
	}

	/**
	 * @param the new health points of the bomb
	 */
	public void setHp(int value) {
		hp = value;
	}
	
	/**
	 * @return the damage reduction of the bomb
	 */
	public int getDamageReduction() {
		return 0;
	}
}
