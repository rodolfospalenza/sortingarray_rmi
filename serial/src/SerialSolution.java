import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;

public class SerialSolution {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Digite quantos escravos sera utilizado: ");
		int nslaves = Integer.parseInt(br.readLine());

		PrintStream ps = new PrintStream("nslaves_" + nslaves + ".csv");
		ps.println("sizearray; " + nslaves + "_slaves");

		while (true) {
			System.out.print("Entre com o tamanho do vetor: ");
			int size = Integer.parseInt(br.readLine());

			System.out.print("Entre com o valor maximo de vetor: ");
			int vmax = Integer.parseInt(br.readLine());

			int[] n = Utils.randomIntArray(size, vmax);

			long startTime = System.nanoTime();
			Arrays.sort(n);
			long estimatedTime = System.nanoTime() - startTime;

			System.out.println(estimatedTime);
			ps.println(vmax + "; " + estimatedTime);
		}
	}
}
