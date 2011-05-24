import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SlaveManager {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Digite o endereco do servidor de nomes: ");
		String host = br.readLine();

		if (host.isEmpty())
			host = null;

		System.out.print("Digite o nome do mestre: ");
		String mestre = br.readLine();

		if (mestre.isEmpty())
			mestre = "mestre";

		System.out.print("Digite o nome do escravo: ");
		String nome = br.readLine();
		
		// CRIA ESCRAVO
		SlaveImpl slave = new SlaveImpl(mestre, nome);
		

		while (true) {
			System.out.println();
			System.out.println("1 - Registrar");
			System.out.println("2 - Desregistrar");
			System.out.print("Entre com a opcao: ");

			int key = Integer.parseInt(br.readLine());

			switch (key) {
			case 1:
				slave.bind(host);
				break;

			case 2:
				slave.unbind(host);
				System.exit(0);
				break;

			default:
				System.out.println("Digite a opcao correta.");
				break;
			}
		}
	}
}
