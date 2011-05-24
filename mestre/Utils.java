import java.util.Random;

public class Utils {

	// GERAR ARRAY DE INTEIROS RANDOMICO DE TAMANHO length E INTEIRO MAXIMO n.
	public static int[] randomIntArray(int length, int n) {
		int[] a = new int[length];
		Random generator = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = generator.nextInt(n);
		}
		return a;
	}
}
