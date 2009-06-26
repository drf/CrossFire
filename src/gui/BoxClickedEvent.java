package gui;

import gameChart.Box;

import java.util.EventObject;

public class BoxClickedEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7003745071875849062L;

	public BoxClickedEvent(Box source) {
		super(source);
	}
	
	public Box getBox() {
		return (Box)getSource();
	}

}
