package items;

import gameChart.Box;
import gameLogic.Attackable;
import globals.Entity;

public class Bomb extends globals.Entity  {

	int hp;
	
	public Bomb() {
		hp = 10;
	}
	
	public int getDexterity() {
		return 0;
	}

	
	public int getHp() {
		return hp;
	}

	
	public int getLuck() {
		return 0;
	}

	public int getStrength() {
		return 10;
	}

	public void onDeath() {
		// Deal 10 damage to each unity in the adjacent boxes
		for (Box box : getBox().getAdjacentBoxes()) {
			Entity ent = box.getChart().getEntityOn(box);
			if (ent instanceof Attackable) {
				int newhp = ((Attackable)ent).getHp();
				
				if (newhp <= 0) {
					newhp = 0;
					((Attackable)ent).setHp(newhp);
					((Attackable)ent).onDeath();
				} else {
					((Attackable)ent).setHp(newhp);
				}
			}
		}
	}

	public void setHp(int value) {
		hp = value;
	}
	
	public void boxChanged(Box oldBox, Box newBox) {
		
	}

}
