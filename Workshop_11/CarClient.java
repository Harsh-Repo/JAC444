import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/** A class that represent the car client
 * @author Harsh Patel
 * @seneca_id 146315205 
 * @Class JAC444NAA
 * @email: hpatel262@myseneca.ca 
 *  */
public class CarClient {
	
	/**
	 * Creates a new car with undefined plate.
	 * Send this car to be register in the server.
	 * Receives the registered car from the server along with plate number.
	 */
	public static void main(String[] args) {
		try {
			
			System.out.println("**** Car Details ****");
			
			Car car = new Car("Camry", "Matte Black", 15);
			
			System.out.println(car.toString());
			System.out.println("\nGenerating plate number ...");
						
			CarInterface obj = (CarInterface) Naming.lookup("rmi://localhost:8081/generatePlateNumber");
			car.setPlate(obj.registerCar(car));
						
			System.out.println("New plate number generated: " + car.getPlate());
			System.out.println("\nNew Car Registered");
			System.out.println("**** Updated Car Details ****");
			System.out.println(car.toString());
			
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
		} catch (NotBoundException e) {
			System.out.println(e.getMessage());
		}
	}
}