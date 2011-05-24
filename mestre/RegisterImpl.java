import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@SuppressWarnings("serial")
public class RegisterImpl extends UnicastRemoteObject implements Register {
	private static HashMap<String, Remote> slaves;

	protected RegisterImpl() throws RemoteException {
		super();
		this.setSlaves(new HashMap<String, Remote>());
	}

	public void rebind(String name, Remote obj) {
		if (slaves.containsKey(name)) {
			RegisterImpl.getSlaves().put(name, obj);
			System.out.println("Escravo " + name + " reregistrado.");
		} else {
			RegisterImpl.getSlaves().put(name, obj);
			System.out.println("Escravo " + name + " registrado.");
		}
	}

	public void unbind(String name) {
		RegisterImpl.getSlaves().remove(name);
		System.out.println("Escravo " + name + " desregistrado.");
	}

	private void setSlaves(HashMap<String, Remote> slaves) {
		RegisterImpl.slaves = slaves;
	}

	public static ArrayList<String> getSlavesName() {
		ArrayList<String> nameslaves = new ArrayList<String>();
		for (Object x : slaves.keySet().toArray())
			nameslaves.add(x.toString());
		return nameslaves;
	}
	
	public static HashMap<String, Remote> getSlaves() {
		return slaves;
	}

	@SuppressWarnings("static-access")
	@Override
	public int[] sendArraySorting(int[] array) throws RemoteException {
		if (!this.getSlaves().isEmpty()) {
			Tasks tasks = new Tasks();

			Mergesort mergesort = new Mergesort(array.length);

			return mergesort.mergesort(tasks.breakArray(array));

		} else {
			System.out
					.println("Nao ha escravos. Mestre realiazando a ordenacao.");
			Arrays.sort(array);
			return array;
		}
		
	}

	public static Remote getSlave(String nameSlave) {
		return slaves.get(nameSlave);
	}
}