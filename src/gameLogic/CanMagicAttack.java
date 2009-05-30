package gameLogic;

public interface CanMagicAttack extends CanAttack {

	public int getIntelligence();
	public int getMagicSkill();

	public boolean canMagicAttack();
}
