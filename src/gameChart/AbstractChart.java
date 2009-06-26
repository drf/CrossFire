package gameChart;

import globals.Entity;
import globals.PlayableEntity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This class represents the game chart in an abstract shape. It has
 * no coordinates or physical references, and it implements only the shared logic
 * to allow easy creation of any kind of chart
 * 
 * @author Dario Freddi
 * @author Vincenzo Iozzo
 *
 */
public abstract class AbstractChart {
	
	private Map<Entity, Box> positions = new HashMap<Entity, Box>();
	
	/**
	 * @return all the boxes in the chart
	 */
	public Set<Box> getBoxes() {
		HashSet<Box> retset = new HashSet<Box>();
		for (Box item : positions.values()) {
			retset.add(item);
		}
		return retset;
	}

	/**
	 * This function is meant to return all boxes adjacent to the chosen one
	 *  
	 * @param b the {@link Box} to check for
	 * @return the {@link Box}es adjacent to b
	 */
	abstract Set<Box> getAdjacentBoxes(Box b);
	
	/**
	 * This function should be reimplemented to create the actual chart. This
	 * should create the shape, the boxes, and everything needed by the chart itself.
	 * The chart is considered invalid until this function gets called
	 */
	abstract void createChart();
	
	/**
	 * @param b the {@link Box} in question
	 * @return the entities on the chosen box
	 */
	public Set<Entity> getEntitiesOn(Box b) {
		HashSet<Entity> retset = new HashSet<Entity>();
		for (Entity item : positions.keySet()) {
			if (positions.get(item) == b) {
				retset.add(item);
			}
		}
		return retset;
	}

	/**
	 * This function returns whether a {@link Box} is busy for a chosen {@link Entity}. This
	 * result should always be checked before attempting to place an item on the chart. Please note
	 * that on a Box can co-exist an infinite number of entities, but one and only {@link PlayableEntity}
	 * 
	 * @param box the {@link Box} in question
	 * @param entity the {@link Entity} about to be placed
	 * @return whether the {@link Entity} can be placed or not
	 */
	public boolean isBoxBusyFor(Box box, Entity entity) {
		if (!(entity instanceof PlayableEntity)) {
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
	
	/**
	 * @param t the {@link Entity} in question
	 * @return the {@link Box} on which the Entity stands
	 */
	public Box getBoxOwnedBy(Entity t) {
		return positions.get(t);
	}
	
	/**
	 * 
	 * @return all the {@link Entity} on the chart
	 */
	public Set<Entity> getEntities() {
		return positions.keySet();
	}
	
	/**
	 * Places an {@link Entity} on the chart and removes it from its previous position
	 * if it was placed elsewhere before. The function also checks if the chosen {@link Box}
	 * is busy for it
	 * 
	 * @param t the {@link Entity} to place
	 * @param b the destination {@link Box}
	 * @throws BoxBusyException if the chosen {@link Box} is busy
	 * 
	 * @see isBoxBusyFor
	 */
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
	
	/**
	 * Removes an entity from the chart
	 * 
	 * @param t the entity to remove
	 */
	public void remove(Entity t) {
		positions.remove(t);
	}
	
	/**
	 * Gets a set of {@link Box}es in the chosen range from a chosen box
	 * 
	 * @param b the box in question
	 * @param range the chosen range
	 * @return a set of {@link Box}es in the chosen range
	 */
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
	
	public Set<Box> getBoxesAtRange(Box b, int range) {
		HashSet<Box> retset = new HashSet<Box>();
		HashSet<Box> latestBoxes = new HashSet<Box>();
		latestBoxes.add(b);
		
		for (int i = 0; i < range; i++) {
			HashSet<Box> currentBoxes = new HashSet<Box>();
			for (Box box : latestBoxes) {
				currentBoxes.addAll(getAdjacentBoxes(box));
			}
			latestBoxes.clear();
			latestBoxes.addAll(currentBoxes);
			currentBoxes.clear();
		}
		
		retset.addAll(latestBoxes);
		
		return retset;
		
	}
	
}
