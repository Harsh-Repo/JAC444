package shapes;

/** This class handles exceptions for the Rectangle class and its child classes */
public class RectangleException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor accepts a string for the message	
	 * @param message A string representing the message
	 */
	public RectangleException(String message) {
		super(message);
	}
}