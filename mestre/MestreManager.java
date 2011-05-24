import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MestreManager {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Digite o nome do mestre: ");
		String nome = br.readLine();

		if (nome.isEmpty())
			nome = "mestre";

		// CRIA MESTRE
		MestreImpl slave = new MestreImpl(nome);
		slave.bind();
	}
}
