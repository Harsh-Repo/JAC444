package shapes;

/** This class handles exceptions for the Circle class */
public class CircleException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor accepts a string for the message
	 * @param message A string representing the message
	 */
	public CircleException(String message) {
		super(message);
	}
}