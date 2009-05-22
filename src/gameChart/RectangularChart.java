package gameChart;

import globals.Pair;

import java.util.HashSet;
import java.util.Set;

public class RectangularChart extends AbstractChart {

	private int width;
	private int height;

	private Box chart[][];
	
	public enum Direction {
		North,
		South,
		West,
		East
	}
	
	public RectangularChart() {
		// TODO Auto-generated constructor stub
	}
	
	public RectangularChart(int width, int height) {
		setSize(width, height);
	}

	private Pair<Integer> getBoxPosition(Box b) {		
		for (int i = 0; i < width; ++i) {
			for (int j = 0; j < height; ++j) {
				if (chart[i][j] == b) {
					return new Pair<Integer>(i, j);
				}
			}
		}
		
		// Return a null pair
		return new Pair<Integer>();
	}
	
	@Override
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
 
	public int getWidth() {
		return width;
	}

	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
		chart = new Box[width][height];
		
	}
	
	public int getHeight() {
		return height;
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
	
	private void createChart() {
		
	}
}
