package gameLogic;

public interface CanRangedAttack extends CanAttack {
	public int getDexterity();
	public int getLuck();
	public int getStrength();
	
	public boolean canRangedAttack();
}
