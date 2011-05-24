
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SortingArray extends Remote {
	int[] sendArraySorting(int[] array) throws RemoteException;
}
