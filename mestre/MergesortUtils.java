public class MergesortUtils {
	private int[] values;
	private int indice;

	public MergesortUtils(int[] values, int indice) {
		this.setValues(values);
		this.setIndice(indice);
	}

	public void setValues(int[] values) {
		this.values = values;
	}

	public int[] getValues() {
		return values;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public int getIndice() {
		return indice;
	}

	public int getValueIndice() {
		return this.values[this.indice];
	}

	public void setNextIndice() {
		this.setIndice(this.indice + 1);
	}
}