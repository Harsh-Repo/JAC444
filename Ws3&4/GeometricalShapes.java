package shapes;

import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Harsh
 *
 */
public class GeometricalShapes {
	
	public static final String CIRCLE = "circle";
	public static final String RECTANGLE = "rectangle";
	public static final String SQUARE = "square";
	public static final String PARALLELOGRAM = "parallelogram";
	public static final String TRIANGLE = "triangle";

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		int count = 0;
		int arraySize = 100;
		Shape[] shapesArray = new Shape[arraySize];
		String filePath = "C:\\Users\\Harsh\\eclipse-workspace\\shapes\\src\\ShapesInput.txt";
	    performTasks(count,shapesArray,arraySize,filePath);

	}
	/**
	 * @param shapesArray 
	 * @param arraySize 
	 * @param filePath 
	 * 
	 */
	public static void performTasks(int count, Shape[] shapesArray, int arraySize, String filePath) {
		
		System.out.println("------->JAC 444 Assignment 1<-------");
		System.out.println("------->Task 1 ... <-------");			
		String inputShape;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			while ((inputShape = br.readLine()) != null) {
				
				String[] tokens = inputShape.split(",");
			
				try {
					
					Shape shape = findShapeType(tokens);
					
					if (shape != null) {
						shapesArray[count] = shape;
						count++;
						if (count == arraySize) {
							Shape[] tempShapeArray = new Shape[arraySize];
							System.arraycopy(shapesArray, 0, tempShapeArray, 0, arraySize);
							arraySize *= 2;
							shapesArray = new Shape[arraySize];
							System.arraycopy(tempShapeArray, 0, shape, 0, tempShapeArray.length);
						}
					}
					
					shape = null;
					
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			
			System.out.println(count + " shapes were created:");
			
			printFinalShapeOutput(count, shapesArray);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		task2(shapesArray,count);
		task3(shapesArray,count);
		
		
		
	}
	

	
	/**
	 * This method will Delete the triangle with the minimum perimeter and the circle with the maximum perimeter
	 * @param shapeArray
	 * @param count
	 */
	private static void task2(Shape[] shapeArray, int count) {
		System.out.println("\n------->Task 2 ... <-------\n");
		
		double minPerimeter = 100;
		double maxPerimeter = 0;
			
		// Find minimum perimeter in Triangle Shape
		for (int i = 0; i < count; i++) {
			if (shapeArray[i] instanceof Triangle) {
				if (shapeArray[i].getPerimeter() < minPerimeter) {
					minPerimeter = shapeArray[i].getPerimeter();
				}
			}
		}
		
		// Delete Triangles with the minimum perimeter
		for (int i = 0; i < count; i++) {
			if (shapeArray[i] instanceof Triangle) {
				if (shapeArray[i].getPerimeter() == minPerimeter) {
					shapeArray[i] = null;
				}
			}
		}
		
		// Find maximum perimeter in Circle Shape 
		for (int i = 0; i < count; i++) {
			if (shapeArray[i] instanceof Circle) {
				if (shapeArray[i].getPerimeter() > maxPerimeter) {
					maxPerimeter = shapeArray[i].getPerimeter();
				}
			}
		}
		// Delete Circles with the maximum perimeter
		for (int i = 0; i < count; i++) {
			if (shapeArray[i] instanceof Circle) {
				if (shapeArray[i].getPerimeter() == maxPerimeter) {
					shapeArray[i] = null;
				}
			}
		}
		printFinalShapeOutput(count,shapeArray);

	}

	
	/**
	 * This method will Calculate and print the total perimeter of all parallelograms and 
	 * the total perimeter of all triangles.
	 * @param shapeArray
	 * @param count
	 */
	private static void task3(Shape[] shapeArray, int count) {
		System.out.println("\n------->Task 3 ... <-------\n");
		
		double parallelogramTotal = 0;
		double triangleTotal = 0;
		
		// Parallelogram perimeter Total
		for (Shape p : shapeArray) {
			if (p instanceof Parallelogram) {
				parallelogramTotal += p.getPerimeter();
			}
		}
		// Triangle perimeter Total
		for (Shape t : shapeArray) {
			if (t instanceof Triangle) {
				triangleTotal += t.getPerimeter();
			}
		}
		System.out.printf("Total perimeter of Parallelogram is: " + parallelogramTotal);
		System.out.printf("\nTotal perimeter of Triangle is: "+ triangleTotal);
		
	}


	/**
	 * @param count
	 * @param shapesArray
	 */
	public static void printFinalShapeOutput(int count, Shape[] shapesArray) {
		for (int i = 0; i < count; i++) {
			if(shapesArray[i]!=null) {
			System.out.println(shapesArray[i]);
			}
		}
	}

	/**
	 * @param shape
	 * @param tokens
	 * @return
	 * @throws Exception
	 */
	public static Shape findShapeType(String[] tokens) throws Exception {
		List<Shape> triangleList= new ArrayList<>();
		Shape shape = null;
		if (tokens[0].equalsIgnoreCase(CIRCLE) && tokens.length==2) {
			shape = new Circle(Double.parseDouble(tokens[1]));
		} else if (tokens[0].equalsIgnoreCase(RECTANGLE)&& tokens.length==3) {
			shape = new Rectangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
		} else if (tokens[0].equalsIgnoreCase(SQUARE) && tokens.length==2) {
			shape = new Square(Double.parseDouble(tokens[1]));
		} else if (tokens[0].equalsIgnoreCase(PARALLELOGRAM) && tokens.length==3) {
			shape = new Parallelogram(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
		} else if (tokens[0].equalsIgnoreCase(TRIANGLE) && tokens.length==4) {
			shape = new Triangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]),
					Double.parseDouble(tokens[3]));
			triangleList.add(shape);
		}
		return shape;
	}

		
	}

