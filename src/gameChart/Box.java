package gameChart;

import java.util.Set;



/**
 * 
 * <b>Box</b> is an abstract class. The idea behind this class is to have a way to manage the landscape of a game chart.
 * The attributes are: 
 * <ul>
 * <li>chart the chart we are playing on
 * </ul>
 * Each attribute has a getter.
 * @author	Dario Freddi
 * @author	Vincenzo Iozzo
 */
public abstract class Box {
	
	AbstractChart chart;
	
	public Box(AbstractChart chart) {
		this.chart = chart;
	}
	
	public AbstractChart getChart() {
		return chart;
	}
	
	/**
	 * This is an opaque method to get the boxes near by. 
	 * This method always returns immediately. 
	 *
	 * @return a set of boxes around ours.
	 * @see AbstractChart
	 * 
	 */
	public Set<Box> getAdjacentBoxes() {
		return chart.getAdjacentBoxes(this);
	}
	
	/**
	 * This is a method used to check if a given box is adjacent to ours.
	 * It works as follow: First we try to undestand if the two boxes are on the same chart, 
	 * then we make sure that the box is near ours. 
	 * This method always returns immediately. 
	 *
	 * @param b the box we are interested in
	 * @return <b>true</b> if the box b is adjacent, <b>false</b> otherwise
	 * @see AbstractChart
	 * 
	 */
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
