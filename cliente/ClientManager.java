import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;

public class ClientManager {
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

		System.out.print("Entre com o numero de escravos que sera testado: ");
		int nslaves = Integer.parseInt(br.readLine());
		
		PrintStream ps = new PrintStream("nslaves_" + nslaves + ".csv");
		ps.println("sizearray; nanotime");
		
		System.out.print("Digite o tamanho do vetor: ");
		int size = Integer.parseInt(br.readLine());
				
		System.out.print("Digite o maior inteiro que o vetor pode ter: ");
		int nmax = Integer.parseInt(br.readLine());

		System.out.println();

		long[] times = null;
		while (true) {

			System.out.println("1 - Run.");
			System.out.println("2 - Imprimir media de tempo.");
			System.out.println("3 - Mudar tamanho do vetor.");
			System.out.println("4 - Mudar o numeros de escravos.");
			System.out.print("Entre com a opcao: ");

			int key = Integer.parseInt(br.readLine());

			switch (key) {
			case 1:

				System.out
						.print("Digite quantas vezes deseja rodar o programa: ");
				int nruns = Integer.parseInt(br.readLine());
				times = new long[nruns];

				for (int i = 0; i < times.length; i++)
					times[i] = 0;

				for (int i = 0; i < nruns; i++) {
					ClientImpl clientImpl = new ClientImpl(mestre, null, size,
							nmax);

					long startTime = System.nanoTime();
					clientImpl.lookup();
					long estimatedTime = System.nanoTime() - startTime;

					// System.out.println(estimatedTime);
					times[i] = estimatedTime;
				}
				break;

			case 2:
				if (times != null) {
					Arrays.sort(times);
					if (times.length == 1) {
						System.out.println("TEMPO MEDIO "
								+ (times[0] + " nanosegundos"));
						ps.println(size + "; " + times[0]);
						break;
					}
					if (times.length % 2 != 0) {
						int div = times.length / 2;
						System.out.println("TEMPO MEDIO "
								+ (times[div] + times[div + 1]) / 2
								+ " nanosegundos");
						ps.println(size + "; " + (times[div] + times[div + 1]) / 2);
					} else {
						int div = times.length / 2;
						System.out.println("TEMPO MEDIO "
								+ (times[div] + " nanosegundos"));
						ps.println(size + "; " + times[div]);
					}

				}
				break;

			case 3:
				System.out.print("Digite o tamanho do vetor: ");
				size = Integer.parseInt(br.readLine());
				times = new long[size];

				System.out
						.print("Digite o maior inteiro que o vetor pode ter: ");
				nmax = Integer.parseInt(br.readLine());
				break;

			case 4:
				System.out
						.print("Entre com o numero de escravos que sera testado:  ");
				nslaves = Integer.parseInt(br.readLine());
				break;

			default:
				System.out.println("Opcao invalida");
				System.out.println();
				break;
			}

			System.out.println();
			System.out.println();
		}
	}
}
