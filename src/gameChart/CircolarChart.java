package gameChart;

import globals.Pair;

import java.util.Set;

public class CircolarChart extends AbstractChart {

	public CircolarChart() {
		// TODO Auto-generated constructor stub
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

	@Override
	public Set<Box> getAdjacentBoxes(Box b) {
		// TODO Auto-generated method stub
		return null;
	}

}
