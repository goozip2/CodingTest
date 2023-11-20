import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();

		Integer[] A = new Integer[N];
		Integer[] B = new Integer[N];

		for (int i = 0; i < N; i++) {
			A[i] = scan.nextInt();
		}
		for (int i = 0; i < N; i++) {
			B[i] = scan.nextInt();
		}

		// A 내림차순
		Arrays.sort(A, Collections.reverseOrder());
		// B 오름차순
		Arrays.sort(B);

		int result = 0;
		for (int i = 0; i < N; i++) {
			result += A[i] * B[i];
		}
		System.out.print(result);
	}
}
