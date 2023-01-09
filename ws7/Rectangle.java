/**
 * 
 */
package shapes;

/**
 * @author Harsh
 *Rectangle class will take width, height as parameter and calculate the perimeter and area for Rectangle shape.
 *Also check for exception if the input is invalid.
 */
public class Rectangle implements Shape {
	private double width;
	private double height;
	
	public ShapeArea obj = () -> getWidth() * getHeight();

	Rectangle(double w, double h) throws RectangleException {
		if (w > 0.0 && h > 0.0) {
			setWidth(w);
			setHeight(h);
			
		}else {
			if(h==w) {
				throw new RectangleException("Invalid side(s)!");
			}
			throw new RectangleException("Invalid side(s)!");
		}
	
	}
	

	public double getWidth() {
		return width;
	}


	public void setWidth(double width) {
		this.width = width;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	@Override
	public String toString() {
		return "Rectangle {" + "w=" + getWidth() + ", h=" + getHeight() + "} perimeter = " + getPerimeter() + " area = " +obj.calculateArea();
	}


	@Override
	public double getPerimeter() {
		return 2 * (height + width);
	}

	
	
}
