/**
 * 
 */
package shapes;

/**
 * @author Harsh
 *Parallelogram class which is extended from rectangle shape class, will take width, height as parameter and calculate the perimeter and area for Parallelogram shape.
 *Also check for exception if the input is invalid.
 */
public class Parallelogram extends Rectangle {
	
	/*
	 * private double width; private double height;
	 */
	
	Parallelogram(double w, double h) throws RectangleException {
		super(w, h);
	}

	@Override
	public double getPerimeter() {
		return 2 * (getHeight() + getWidth() );
	}

	@Override
	public String toString() {
		return "Parallelogram {width=" + getWidth() + ", height=" + getHeight() + "}, perimeter=" + getPerimeter() ;
	}

}
