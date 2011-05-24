import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Tasks {
	private Box box;
	private Thread[] thr;

	public Tasks() {
		this.box = new Box();
		this.thr = new Thread[RegisterImpl.getSlaves().size()];
	}

	public List<MergesortUtils> breakArray(int[] values) {

		Iterator<String> slaves = RegisterImpl.getSlavesName().iterator();

		int tamanho = values.length / RegisterImpl.getSlaves().size();
		int sobra = values.length % RegisterImpl.getSlaves().size();
		int incremento;

		int low = 0;

		for (int i = 0; i < RegisterImpl.getSlaves().size(); i++, sobra--) {
			if (sobra > 0)
				incremento = 1;
			else
				incremento = 0;

			// CRIA CLASSE PARA THREAD SLAVE
			SlaveThread slavethread = new SlaveThread(Arrays.copyOfRange(
					values, low, low + tamanho + incremento), slaves.next(),
					this.box);

			// COLOCA A THREAD EM UM ARRAY
			thr[i] = new Thread(slavethread);
			thr[i].start();

			low = low + tamanho + incremento;

		}

		for (int i = 0; i < RegisterImpl.getSlaves().size(); i++) {
			try {
				thr[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return box.getCampos();
	}
}
