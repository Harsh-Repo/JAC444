/**
 * 
 */
package shapes;

/**
 * @author Harsh
 *Square class will take side as parameter and calculate the perimeter and area for square shape.
 *Also check for exception if the input is invalid.
 */

public class Square extends Rectangle {
	
	Square(double s) throws RectangleException {
		super(s, s);
	}

	/**
	 * No need for setter as we are extending the square class from rectangle.
	 */
	
	@Override
	public String toString() {
		return "Square {" + "s=" + getWidth() + "} perimeter = " + getPerimeter() + " area = " +obj.calculateArea();
	}

	@Override
	public double getPerimeter() {
		return 4 * getWidth();
	}

}
