/**
 * 
 */
package shapes;

/**
 * @author Harsh
 *Triangle class will take 3 sides as parameter and calculate the perimeter for Triangle shape.
 *Also check for exception if the input is invalid.
 */
public class Triangle implements Shape {
	 private double side1;
	 private double side2;
	 private double side3;
	 
	Triangle(double side1, double side2, double side3) throws TriangleException {
		if (side1 <= 0.0 || side2 <= 0.0 || side3 <= 0.0) {
			throw new TriangleException("Invalid side(s)!");
		} 
		
		if((side1 + side2) > side3 && (side1 + side3) > side2 && (side2 + side3) > side1) {

			this.side1 = side1;
			this.side2 = side2;
			this.side3 = side3;
		}else {
			throw new TriangleException("Invalid side(s)!");
		}
		
	}

	public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) {
		this.side1 = side1;
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) {
		this.side2 = side2;
	}

	public double getSide3() {
		return side3;
	}

	public void setSide3(double side3) {
		this.side3 = side3;
	}

	@Override
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
	
	@Override
	public String toString() {
		return "Triangle {" + "side1=" + side1 + ", side2=" + side2 + ", side3=" + side3 + "} perimeter = " + getPerimeter();
	}

	
}
