import java.util.ArrayList;
import java.util.List;

public class Box {
	private List<MergesortUtils> campos;

	public Box() {
		this.setCampos(new ArrayList<MergesortUtils>());
	}

	public synchronized void putValueSlaves(int[] values) {
		MergesortUtils mu = new MergesortUtils(values, 0);
		getCampos().add(mu);
	}

	public void setCampos(List<MergesortUtils> campos) {
		this.campos = campos;
	}

	public List<MergesortUtils> getCampos() {
		return campos;
	}
}
