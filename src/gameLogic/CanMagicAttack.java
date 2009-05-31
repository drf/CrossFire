package gameLogic;

public interface CanMagicAttack extends CanAttack {

	public int getIntelligence();
	public int getMagicSkill();
	public int getMagicDamageBonus();
	
	public boolean canMagicAttack();
}
