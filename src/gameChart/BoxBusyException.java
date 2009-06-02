package gameChart;

/**
 * <b>BoxBusyException</b> inherits from Exception and it is used to notify that a box is already occupied.
 * @author	Dario Freddi
 * @author	Vincenzo Iozzo
 */
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
