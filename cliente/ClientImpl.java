
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientImpl {
	private String nameServer;
	private String host;
	private int[] array;
	private int size;
	private int maxnumber;

	public ClientImpl(String nameServer, String host, int size, int maxnumber) {
		this.setNameServer(nameServer);
		this.setHost(host);
		this.setSize(size);
		this.setMaxnumber(maxnumber);
		this.setArray(Utils.randomIntArray(this.size, this.maxnumber));

	}

	public void lookup() {
		try {
			Registry registry = LocateRegistry.getRegistry(getHost());
			SortingArray stub = (SortingArray) registry.lookup(this
					.getNameServer());

			stub.sendArraySorting(this.getArray());

		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setNameServer(String nameServer) {
		this.nameServer = nameServer;
	}

	public String getNameServer() {
		return nameServer;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getHost() {
		return host;
	}

	public void setMaxnumber(int maxnumber) {
		this.maxnumber = maxnumber;
	}

	public int getMaxnumber() {
		return maxnumber;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	private void setArray(int[] array) {
		this.array = array;
	}

	private int[] getArray() {
		return array;
	}
}
