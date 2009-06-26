package gameLogic;

import globals.Entity;

/**
 * <b>Attackable</b> should be implemented by every   {@link Entity}   that can be attacked, hence damaged and killed. Every   {@link Attackable}   can take part in a fight as the attacked   {@link Entity}
 * @author   Dario Freddi
 * @author   Vincenzo Iozzo
 */
public interface Attackable {
	/**
	 * @return the strength of the object implementing the interface
	 */
	public int getStrength();
	/**
	 * @return the luck of the object implementing the interface
	 */
	public int getLuck();
	/**
	 * @return the dexterity of the object implementing the interface
	 */
	public int getDexterity();
	/**
	 * @return   the health points of the object implementing the interface
	 * @uml.property  name="hp"
	 */
	public int getHp();
	/**
	 * Set the new health points of the attacked object. This function will be called whenever some damage gets inflicted
	 * @param value   the new health points of the object
	 * @uml.property  name="hp"
	 */
	public void setHp(int value);
	/**
	 * @return the damage reduction of the object implementing the interface
	 */
	public int getDamageReduction();

	/**
	 * This function will be called whenever the class implementing the interface
	 * gets killed. In this function, it is possible to perform some actions, such as
	 * dropping items, damaging nearby opponents, etc
	 */
	public void onDeath();
}
