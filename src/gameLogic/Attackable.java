package gameLogic;

public interface Attackable {
	public int getStrength();
	public int getLuck();
	public int getDexterity();
	public int getHp();
	public void setHp(int value);
}
