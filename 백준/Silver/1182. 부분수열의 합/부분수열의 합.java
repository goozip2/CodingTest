import java.util.Scanner;

public class Main {
	static int[] num;
	private static int N; // 정수의 개수
	private static int S; // 정수의 합
	private static int answer = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		S = scan.nextInt();
		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = scan.nextInt();
		}

		dfs(0, 0);

		// S 0일때가 전체 합이 0 일때랑 겹치기 때문에 -1
		if (S == 0) {
			System.out.println(answer - 1);
		} else {
			System.out.println(answer);
		}
	}

	private static void dfs(int index, int sum) {
		if (index == N) {
			if (sum == S)
				answer++;
			return;
		}
		// index 포함
		dfs(index + 1, sum + num[index]);
		// index 미포함
		dfs(index + 1, sum);
	}
}