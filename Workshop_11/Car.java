import java.io.Serializable;

/** This class creates an instance of type car
 * @author Harsh Patel
 * @seneca_id 146315205 
 * @Class JAC444NAA
 * @email: hpatel262@myseneca.ca 
 * */
public class Car implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String model;
	private String color;
	private int mileage;
	private String plate;
	
	/**
	 * 
	 * @param string model
	 * @param string color
	 * @param integer.mileage
	 */
	public Car(String model, String color, int mileage) {
		this.model = model;
		this.color = color;
		this.mileage = mileage;
		this.plate = "To be registered";
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public int getMileage() {
		return this.mileage;
	}
	
	public String getPlate() {
		return this.plate;
	}
	
	/**
	 * Return a string of the car
	 * @return A Car string
	 */
	@Override
	public String toString() {
		return "Model: " + getModel() + "\nColor: " + getColor() + "\nMileage: "
				+ getMileage() + "\nPlate: " + getPlate();
	}

}