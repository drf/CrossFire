package gameChart;

/**
 * <b>OutOfBoundsException</b> inherits from Exception and it is used to notify that a box is out of the game chart boundaries
 * @author	Dario Freddi
 * @author	Vincenzo Iozzo
 */
public class OutOfBoundsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4287486411823021927L;

	public OutOfBoundsException() {
	}

	public OutOfBoundsException(String message) {
		super(message);
	}

	public OutOfBoundsException(Throwable cause) {
		super(cause);
	}

	public OutOfBoundsException(String message, Throwable cause) {
		super(message, cause);
	}

}
