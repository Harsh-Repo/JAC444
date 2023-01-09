import java.rmi.Remote;
import java.rmi.RemoteException;

/** This is registration interface 
 * @author Harsh Patel
 * @seneca_id 146315205 
 * @Class JAC444NAA
 * @email: hpatel262@myseneca.ca */
public interface CarInterface extends Remote {
	public String registerCar(Car car) throws RemoteException;
}