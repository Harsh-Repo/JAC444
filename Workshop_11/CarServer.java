import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/** This class works as a car registration server 
 * @author Harsh Patel
 * @seneca_id 146315205 
 * @Class JAC444NAA
 * @email: hpatel262@myseneca.ca 
 * */
public class CarServer {
	
	/**
	 * Registration server that waits requests from clients.
	 * Return the new registered plate to the client.
	 */
	public CarServer() {
		try {
			
			CarInterface obj = new CarImplementation();
			
			Registry registry = LocateRegistry.createRegistry(8081);
			registry.rebind("generatePlateNumber", obj);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		new CarServer();
		System.out.println("------------RMI Server for car registration-------------");
	}
}