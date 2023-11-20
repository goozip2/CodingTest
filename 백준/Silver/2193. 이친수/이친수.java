import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		if (N == 0) {
			System.out.print(0);
			return;
		} else if (N == 1) {
			System.out.print(1);
			return;
		}

		long[] dp = new long[N + 1];

		dp[0] = 0; // 임시
		dp[1] = 1;

		for (int i = 2; i <= N; i++) {
			// 10 뒤에 0이 나오는 경우 => dp[n-1]
			// 10 뒤에 1이 나오는 경우 => 1010 => dp[n-2]
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		System.out.print(dp[N]);
		return;
	}
}