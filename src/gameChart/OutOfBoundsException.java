package gameChart;

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
