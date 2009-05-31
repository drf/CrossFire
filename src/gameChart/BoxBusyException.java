package gameChart;

public class BoxBusyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1925586892953923204L;

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
