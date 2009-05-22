package globals;

import gameChart.Box;

public abstract class Token {

	private Box box;
	
	public Token() {}
	
	public Box getBox() {
		return this.box;
	}
	
	public void setBox(Box box) {
		this.box = box;
	}
}
