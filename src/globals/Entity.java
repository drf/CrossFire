package globals;

import gameChart.Box;
import gameChart.BoxBusyException;
import gameLogic.Attackable;
import gameLogic.CanMeleeAttack;
import gameLogic.CombatHandler;

public abstract class Entity {

	private Box box;
	
	public abstract void boxChanged(Box oldBox, Box newBox);
	
	public Entity() {}
	
	public Box getBox() {
		return this.box;
	}
	
	public void setBox(Box box) {
		this.boxChanged(this.box, box);
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
	
	public void attack(Entity to, gameLogic.CombatHandler.AttackType type) {
		switch (type) {
		case Melee:
			meleeAttack(to);
			break;
		default:
			return;
		}
	}
	
	private void meleeAttack(Entity to) {
		if (!(this instanceof gameLogic.CanMeleeAttack) || to instanceof gameLogic.Attackable) {
			return;
		}
		
		if (!box.isAdjacentTo(to.getBox())) {
			return;
		}
		
		CombatHandler.meleeAttack((CanMeleeAttack)this, (Attackable)to);
	}
}
