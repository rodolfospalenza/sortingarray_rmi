import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Register extends Remote {
	void rebind(String name, Remote obj) throws RemoteException;
	void unbind(String name) throws RemoteException;
}
