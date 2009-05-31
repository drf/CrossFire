package gameLogic;

public class PickError extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6527603333584172700L;

	public PickError() {
		 super(); 
	}
	
	public PickError(String s) {
		super(s);
	}
}
