package gameChart;

import globals.Entity;
import globals.Pair;
import globals.PlayableEntity;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractChart {
	
	private int width;
	private int height;

	private Box chart[][];
	private Map<Entity, Box> positions;
	
	public enum Direction {
		North,
		South,
		West,
		East
	}

	public Set<Box> getBoxes() {
		HashSet<Box> retset = new HashSet<Box>();
		for (Box item : positions.values()) {
			retset.add(item);
		}
		return retset;
	}
		
	public Box[][] getChart()
	{
		return chart;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setSize(int width, int height) {
		setWidth(width);
		setHeight(height);
		chart = new Box[width][height];
	}

	abstract Pair<Integer> getBoxPosition(Box b);

	public Set<Box> getAdjacentBoxes(Box b) {
		Pair<Integer> position = getBoxPosition(b);
		
		int w = position.getFirst();
		int h = position.getSecond();
		
		Set<Box> retset = new HashSet<Box>();
		
		if (h + 1 < height) {
			retset.add(chart[w][h+1]);
		}
		if (w + 1 < width) {
			retset.add(chart[w+1][h]);
		}
		if (h - 1 > 0) {
			retset.add(chart[w][h-1]);
		}
		if (w - 1 > 0) {
			retset.add(chart[w-1][h]);
		}
		
		return retset;
	}

	public Box getAdjacentBox(Direction d, Box b) {
		Pair<Integer> position = getBoxPosition(b);
		
		int w = position.getFirst();
		int h = position.getSecond();
		
		switch (d) {
		case North:
			if (h + 1 < height) {
				return chart[w][h+1];
			} else {
				return null;
			}
		case South:
			if (h - 1 > 0) {
				return chart[w][h-1];
			} else {
				return null;
			}
		case East:
			if (w + 1 < width) {
				return chart[w+1][h];
			} else {
				return null;
			}
		case West:
			if (w - 1 > 0) {
				return chart[w-1][h];
			} else {
				return null;
			}
		default:
			return null;
		}
	}

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
