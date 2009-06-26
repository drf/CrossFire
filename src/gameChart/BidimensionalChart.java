package gameChart;

import java.util.HashSet;
import java.util.Set;

import globals.Pair;
import gameChart.LandscapeGenerator;
import gameChart.Box;

/**
 * @author  drf
 */
public abstract class BidimensionalChart extends AbstractChart {

	/**
	 * @uml.property  name="width"
	 */
	private int width;
	/**
	 * @uml.property  name="height"
	 */
	private int height;

	/**
	 * @uml.property  name="chart"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	private Box chart[][];
	
	/**
	 * @author   drf
	 */
	public enum Direction {
		/**
		 * @uml.property  name="north"
		 * @uml.associationEnd  
		 */
		North,
		/**
		 * @uml.property  name="south"
		 * @uml.associationEnd  
		 */
		South,
		/**
		 * @uml.property  name="west"
		 * @uml.associationEnd  
		 */
		West,
		/**
		 * @uml.property  name="east"
		 * @uml.associationEnd  
		 */
		East
	}

	/**
	 * @return
	 * @uml.property  name="chart"
	 */
	public Box[][] getChart()
	{
		return chart;
	}
	
	/**
	 * @return
	 * @uml.property  name="width"
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 * @uml.property  name="width"
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * @return
	 * @uml.property  name="height"
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height
	 * @uml.property  name="height"
	 */
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
		if (h - 1 >= 0) {
			retset.add(chart[w][h-1]);
		}
		if (w - 1 >= 0) {
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
			if (h - 1 >= 0) {
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
			if (w - 1 >= 0) {
				return chart[w-1][h];
			} else {
				return null;
			}
		default:
			return null;
		}
	}
	
	public Box getBoxAt(int w, int h) {
		return chart[w][h];
	}

	public Pair<Integer> getBoxPosition(Box b) {		
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
	
	protected void createChart() {		
		chart = new Box[getWidth()][getHeight()];
		
		for(int i = 0; i< getWidth(); ++i) {
			for(int j=0; j < getHeight(); ++j) {
				chart[i][j] = LandscapeGenerator.generateRandomLandscape(this);
				System.out.println("Generated " + chart[i][j] + " at " + i + j);
			}
		}

	}

}
