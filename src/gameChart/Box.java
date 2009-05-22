package gameChart;

import java.util.Set;

public abstract class Box {
	
	AbstractChart chart;

	public Box(AbstractChart chart) {
		this.chart = chart;
	}
	
	public AbstractChart getChart() {
		return chart;
	}
	
	public Set<Box> getAdjacentBoxes() {
		return chart.getAdjacentBoxes(this);
	}
	
	public boolean isAdjacentTo(Box b) {
		if (getChart() != b.getChart()) {
			return false;
		}
		
		if (!getAdjacentBoxes().contains(b)) {
			return false;
		}
		
		return true;
	}
	
}
