/**
 * 
 */
package shapes;

/**
 * @author Harsh
 *Circle class will take radius as parameter and calculate the perimeter for circle shape.
 *Also check for exception if the input is invalid.
 */
public class Circle implements Shape {

	private double radius;
	private ShapeArea obj = () -> Math.PI * getRadius()* getRadius();

	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	Circle(double radius) throws CircleException {
		if (radius <= 0.0) {
			throw new CircleException("Invalid radius!");
		}
		this.radius = radius;
	}
	
	

	@Override
	public String toString() {
		return "Circle {" + "r=" + radius + "} perimeter = " + getPerimeter() + " area = " + obj.calculateArea() ;
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * getRadius();
		
	}
	
}
