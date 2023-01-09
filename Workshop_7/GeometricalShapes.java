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
		
		System.out.println("------->JAC 444 Assignment 7<-------");
		System.out.println("------->Task 4 ... <-------");			
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

