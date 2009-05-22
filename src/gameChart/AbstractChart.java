package gameChart;

import globals.Token;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractChart {
	
	private Map<Token, Box> positions;
	
	public Set<Box> getBoxes() {
		HashSet<Box> retset = new HashSet<Box>();
		for (Box item : positions.values()) {
			retset.add(item);
		}
		return retset;
	}
	
	public abstract Set<Box> getAdjacentBoxes(Box b);
	
	public Token getTokenOn(Box b) {
		for (Token item : positions.keySet()) {
			if (positions.get(item) == b) {
				return item;
			}
		}
		
		return null;
	}
	
	public boolean isBoxBusy(Box b) {
		return positions.containsValue(b);
	}
	
	public Box getBoxOwnedBy(Token t) {
		return positions.get(t);
	}
	
	public Set<Token> getTokens() {
		return positions.keySet();
	}
	
	public void move(Token t, Box b) throws BoxBusyException {
		if (isBoxBusy(b)) {
			throw new BoxBusyException("The chosen box is busy!");
		}
		
		positions.put(t, b);
	}
	
	public void remove(Token t) {
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
