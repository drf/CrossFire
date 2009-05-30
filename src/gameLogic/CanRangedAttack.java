package gameLogic;

public interface CanRangedAttack extends CanAttack {
	
	public int getDexterity();
	public int getStrength();
	public int getRangedAttackBonus();
	
	public boolean canRangedAttack();
}
