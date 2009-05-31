package gameChart;

import globals.Pair;


public class RectangularChart extends AbstractChart {


	public RectangularChart() {
		// TODO Auto-generated constructor stub
	}
	
	public RectangularChart(int width, int height) {
		setSize(width, height);
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

	private void createChart() {
		
	}
}
