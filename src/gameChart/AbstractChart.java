package gameChart;

import globals.Entity;

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
	
	public Entity getTokenOn(Box b) {
		for (Entity item : positions.keySet()) {
			if (positions.get(item) == b) {
				return item;
			}
		}
		
		return null;
	}
	
	public boolean isBoxBusy(Box b) {
		return positions.containsValue(b);
	}
	
	public Box getBoxOwnedBy(Entity t) {
		return positions.get(t);
	}
	
	public Set<Entity> getTokens() {
		return positions.keySet();
	}
	
	public void place(Entity t, Box b) throws BoxBusyException {
		if (isBoxBusy(b)) {
			throw new BoxBusyException("The chosen box is busy!");
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
