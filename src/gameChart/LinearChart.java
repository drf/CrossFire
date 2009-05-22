package gameChart;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class LinearChart extends AbstractChart {
	private int length;
	private Hashtable<Integer, Box> cells;
	
	public LinearChart() {
		// TODO Auto-generated constructor stub
	}
	
	public LinearChart(int length) {
		this.length = length;
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
	
	public Box getBoxAt(int index) throws OutOfBoundsException {
		if (index >= length || index < 0) {
			throw new OutOfBoundsException("You requested an index out of the chart");
		}
		return cells.get(index);
	}
	
	public void insertBox(int index, Box box) throws OutOfBoundsException {
		if (index >= length || index < 0) {
			throw new OutOfBoundsException("You requested an index out of the chart");
		}
		cells.put(index, box);
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
