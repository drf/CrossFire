package gameChart;

import java.util.HashSet;
import java.util.Set;

import globals.Pair;

public class BidimentionalChart extends AbstractChart {

	private int width;
	private int height;

	private Box chart[][];
	
	public enum Direction {
		North,
		South,
		West,
		East
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

	protected Pair<Integer> getBoxPosition(Box b) {		
		for (int i = 0; i < getWidth(); ++i) {
			for (int j = 0; j < getHeight(); ++j) {
				if (getChart()[i][j] == b) {
					return new Pair<Integer>(i, j);
				}
			}
		}
		// Return a null pair
		return new Pair<Integer>();
	}

}
