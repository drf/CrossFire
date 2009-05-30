package gameLogic;

public interface CanRangedAttack extends CanAttack {
	
	public int getDexterity();
	public int getStrength();
	
	public boolean canRangedAttack();
}
