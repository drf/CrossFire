package gameChart;

import globals.Pair;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class LinearChart extends AbstractChart {
	private Hashtable<Integer, Box> cells;
	
	public LinearChart() {
		// TODO Auto-generated constructor stub
	}
	
	public LinearChart(int width) {
		setSize(width, 0);
	}

	protected Pair<Integer> getBoxPosition(Box b) {		
		for (int i = 0; i < getWidth(); ++i) {
				if (getChart()[i][0] == b) {
					return new Pair<Integer>(i, 0);
				}
		}
		// Return a null pair
		return new Pair<Integer>();
	}

	@Override
	public Set<Box> getAdjacentBoxes(Box b) {
		// Find the index of the box
		for (int item : cells.keySet()) {
			if (cells.get(item) == b) {
				HashSet<Box> retset = new HashSet<Box>();
				if (cells.get(item - 1) != null) {
					retset.add(cells.get(item - 1));
				}
				if (cells.get(item + 1) != null) {
					retset.add(cells.get(item + 1));
				}
				return retset;
			}
		}
		return null;
	}
		

}
