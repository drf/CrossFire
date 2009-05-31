package globals;

import gameChart.Box;
import gameChart.BoxBusyException;
import gameLogic.Movable;

public abstract class Entity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 602249422396237313L;
	private Box box;
	
	public Entity() {}
	
	public Box getBox() {
		return this.box;
	}
	
	public void setBox(Box box) {
		if (this instanceof Movable) {
			((Movable)this).boxChanged(this.box, box);
		}
		this.box = box;
	}
	
	public void move(Box toBox) {
		if (!(this instanceof gameLogic.Movable)) {
			return;
		}
		
		if (!box.isAdjacentTo(toBox)) {
			return;
		}
		
		try {
			box.getChart().place(this, toBox);
		} catch (BoxBusyException e) {
			return;
			// TODO: handle exception
		}
	}
	
}
