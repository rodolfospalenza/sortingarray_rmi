import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Arrays;

public class SlaveThread extends Thread {
	private Box box;
	private String nameSlave;
	private Remote slave;
	private int[] values;

	public SlaveThread(int[] values, String string, Box b) {
		this.values = values;
		this.nameSlave = string;
		this.slave = RegisterImpl.getSlave(nameSlave);
		this.box = b;
	}

	@Override
	public void run() {
		Slave stub = (Slave) this.slave;

		try {
			box.putValueSlaves(stub.sorting(this.values));
		} catch (RemoteException e) {

			// CASO O ESCRAVO FALHE O MESTRE ORDENA O VETOR.

			RegisterImpl.getSlaves().remove(this.nameSlave);

			Arrays.sort(this.values);
			box.putValueSlaves(this.values);
		}
	}
}
