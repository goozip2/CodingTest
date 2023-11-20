import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		Integer[] lope = new Integer[N];
		int[] result = new int[N];

		for (int i = 0; i < N; i++) {
			lope[i] = scan.nextInt();
		}

		Arrays.sort(lope, Collections.reverseOrder());

		for (int i = 0; i < N; i++) {
			result[i] = lope[i] * (i + 1);
		}

		Arrays.sort(result);
		System.out.print(result[N - 1]);
	}

}
