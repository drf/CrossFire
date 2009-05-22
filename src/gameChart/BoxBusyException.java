package gameChart;

public class BoxBusyException extends Exception {

	public BoxBusyException() {
	}

	public BoxBusyException(String message) {
		super(message);
	}

	public BoxBusyException(Throwable cause) {
		super(cause);
	}

	public BoxBusyException(String message, Throwable cause) {
		super(message, cause);
	}

}
