package gameChart;

import globals.Pair;


public class LinearChart extends BidimentionalChart {
	
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
		
}
