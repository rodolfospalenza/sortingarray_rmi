import java.util.List;

public class Mergesort {
	private int[] values;

	public Mergesort(int tamanho) {
		this.values = new int[tamanho];
	}

	public int[] mergesort(List<MergesortUtils> list) {
		int aux;
		int indice = 0;

		MergesortUtils msf, msl = null;

		while (!list.isEmpty()) {
			aux = 999999999;
			for (int i = 0; i < list.size(); i++) {
				msf = list.get(i);

				if (msf.getValueIndice() <= aux) {
					msl = msf;
					aux = msf.getValueIndice();
				}
			}

			this.values[indice] = aux;
			indice = indice + 1;
			msl.setNextIndice();

			if (msl.getIndice() >= msl.getValues().length)
				list.remove(msl);
		}
		return this.values;
	}
}
