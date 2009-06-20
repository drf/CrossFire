package gameLogic;

import java.util.HashSet;

import spells.Spell;

import characters.Fighter;

/**
 * <b>CanMagicAttack</b> grants an object implementing it the capability of performing
 * magic attacks. It implements also all needed requirements to perform a magic attack,
 * by exposing all the getters function for the needed attributes.
 * <p>
 * Since performing magic attacks is both determined by race and attributes conditions,
 * different for each {@link Fighter}, a function that determines whether the target can
 * perform a magic attack is provided 
 * 
 * @author drf
 *
 */
public interface CanMagicAttack extends CanAttack {

	/**
	 * @return the intelligence of the object implementing the interface
	 */
	public int getIntelligence();
	/**
	 * @return the magic skill of the object implementing the interface
	 */
	public int getMagicSkill();
	/**
	 * @return the magic damage bonus of the object implementing the interface
	 */
	public int getMagicDamageBonus();
	
	public HashSet<Spell> getAvailableSpells();
	
	public int getMp();
	public void setMp(int mp);
	
	/**
	 * This function serves as a runtime check to see if the object is actually able
	 * to perform a magic attack. This is needed since magic attacks can have dynamic
	 * requirements (specific attributes, etc), that can not be determined statically.
	 * 
	 * @return whether the object can perform a magic attack or not
	 */
	public boolean canMagicAttack();
}
