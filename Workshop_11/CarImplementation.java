import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/** This class implements the generation function
 * @author Harsh Patel
 * @seneca_id 146315205 
 * @Class JAC444NAA
 * @email: hpatel262@myseneca.ca  */
public class CarImplementation extends UnicastRemoteObject implements CarInterface {
	
	private static final long serialVersionUID = 1L;

	public CarImplementation() throws RemoteException {
		super();
	}
	
	/**
	 * Generate new plate
	 * @return A string of registered plate.
	 */
	@Override
	public String registerCar(Car car) throws RemoteException {
		return " " + car.hashCode();
	}

}