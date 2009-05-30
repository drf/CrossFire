package items;

import gameChart.Box;
import gameLogic.Attackable;
import globals.Entity;

public class Bomb extends globals.Entity implements Attackable {

	int hp;
	
	public Bomb() {
		hp = 10;
	}
	
	@Override
	public int getDexterity() {
		return 0;
	}

	@Override
	public int getHp() {
		return hp;
	}

	@Override
	public int getLuck() {
		return 0;
	}

	@Override
	public int getStrength() {
		return 10;
	}

	@Override
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

	@Override
	public void setHp(int value) {
		hp = value;
	}

}
