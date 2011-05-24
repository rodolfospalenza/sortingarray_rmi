import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Slave extends Remote {
	int[] sorting(int[] array) throws RemoteException;
}
