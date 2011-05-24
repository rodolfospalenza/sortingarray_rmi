import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MestreImpl {
	private String nome;
	
	public MestreImpl(String nome) {
		this.setNome(nome);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public void bind() {
		RegisterImpl obj;
		try {
			obj = new RegisterImpl();
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind(getNome(), obj);
			
			System.out.println("Mestre Running.");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
