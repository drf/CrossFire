package gameChart;

public class OutOfBoundsException extends Exception {

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
