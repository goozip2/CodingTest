import java.util.Scanner;

public class Main {

	static int n, m;
	static boolean isUsed[];
	static int arr[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();

		isUsed = new boolean[n + 1];
		arr = new int[m + 1];

		nm(0);

		System.out.print(sb);
	}

	static void nm(int index) {
		// 인덱스가 마지막 위치에 도달하면 수열 출력
		if (index == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		// 인덱스가 마지막 위치가 아닐 경우,
		// arr에 고른 수를 넣고, 해당 수의 isUsed값을 true로 바꾼 후, 재귀
		for (int i = 1; i <= n; i++) {
			// 고른 수가 새로운 수라면
			if (!isUsed[i]) {
				isUsed[i] = true;
				arr[index] = i;
				nm(index + 1);

				// 재귀 끝나면 다시 안갔던 것처럼
				isUsed[i] = false;
			}
		}
	}

}
