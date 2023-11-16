import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		for (int i = 0; i < testcase; i++) {

			int N = scan.nextInt();

			if (N == 0) {
				System.out.println(1 + " " + 0);
				continue;
			} else if (N == 0) {
				System.out.println(0 + " " + 1);
				continue;
			}

			// dp[피보나치수][0||1]
			int[][] dp = new int[N + 1][2];

			dp[0][0] = 1;
			dp[0][1] = 0;

			dp[1][0] = 0;
			dp[1][1] = 1;

			for (int n = 2; n <= N; n++) {
				dp[n][0] = dp[n - 1][0] + dp[n - 2][0];
				dp[n][1] = dp[n - 1][1] + dp[n - 2][1];
			}
			System.out.println(dp[N][0] + " " + dp[N][1]);
		}

	}

}
