import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

@SuppressWarnings("serial")
public class SlaveImpl extends UnicastRemoteObject implements Slave {
	private String mestre;
	private String nome;

	public SlaveImpl(String mestre, String nome) throws RemoteException {
		this.mestre = mestre;
		this.setNome(nome);
	}

	public SlaveImpl() throws RemoteException {
		super();
	}

	public void setMestre(String mestre) {
		this.mestre = mestre;
	}

	public String getMestre() {
		return mestre;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void bind(String host) {
		Registry registry;
		try {
			registry = LocateRegistry.getRegistry(host);
			Register stub = (Register) registry.lookup(getMestre());

			SlaveImpl slave = new SlaveImpl();
			stub.rebind(getNome(), slave);

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void unbind(String host) {
		Registry registry;
		try {
			registry = LocateRegistry.getRegistry(host);
			Register stub = (Register) registry.lookup(this.mestre);

			stub.unbind(this.nome);

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int[] sorting(int[] array) throws RemoteException {
		Arrays.sort(array);
		return array;
	}
}