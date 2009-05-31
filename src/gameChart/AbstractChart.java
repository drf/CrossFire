package gameChart;

import globals.Entity;
import globals.PlayableEntity;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractChart {
	
	private Map<Entity, Box> positions;
	
	public Set<Box> getBoxes() {
		HashSet<Box> retset = new HashSet<Box>();
		for (Box item : positions.values()) {
			retset.add(item);
		}
		return retset;
	}
	
	public abstract Set<Box> getAdjacentBoxes(Box b);
	
	public Set<Entity> getEntitiesOn(Box b) {
		HashSet<Entity> retset = new HashSet<Entity>();
		for (Entity item : positions.keySet()) {
			if (positions.get(item) == b) {
				retset.add(item);
			}
		}
		return retset;
	}
	
	public boolean isBoxBusyFor(Box box, Entity entity) {
		if (entity instanceof PlayableEntity) {
			// In this case, it can be on any box at any moment
			return false;
		}
		
		for (Entity item : positions.keySet()) {
			if (positions.get(item) == box) {
				if (item instanceof PlayableEntity) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public Box getBoxOwnedBy(Entity t) {
		return positions.get(t);
	}
	
	public Set<Entity> getEntities() {
		return positions.keySet();
	}
	
	public void place(Entity t, Box b) throws BoxBusyException {
		if (isBoxBusyFor(b, t)) {
			throw new BoxBusyException("The entity can not be on the chosen box!");
		}
		
		if (positions.containsKey(t)) {
			positions.remove(t);
		}
		
		positions.put(t, b);
		t.setBox(b);
	}
	
	public void remove(Entity t) {
		positions.remove(t);
	}
	
	public Set<Box> getBoxesInRange(Box b, int range) {
		HashSet<Box> retset = new HashSet<Box>();
		HashSet<Box> latestBoxes = new HashSet<Box>();
		latestBoxes.add(b);
		
		for (int i = 0; i < range; i++) {
			HashSet<Box> currentBoxes = new HashSet<Box>();
			for (Box box : latestBoxes) {
				currentBoxes.addAll(getAdjacentBoxes(box));
			}
			retset.addAll(latestBoxes);
			latestBoxes.clear();
			latestBoxes.addAll(currentBoxes);
			currentBoxes.clear();
		}
		
		retset.addAll(latestBoxes);
		
		return retset;
		
	}

}
