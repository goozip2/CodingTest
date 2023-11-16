import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		for (int i = 0; i < testcase; i++) {
			int n = scan.nextInt();
			if (n == 1) {
				System.out.println(1);
				continue;
			}
			if (n == 2) {
				System.out.println(2);
				continue;
			}
			if (n == 3) {
				System.out.println(4);
				continue;
			}
			int[] dp = new int[n + 1];
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;

			for (int x = 4; x <= n; x++) {
				dp[x] = dp[x - 3] + dp[x - 2] + dp[x - 1];
			}

			System.out.println(dp[n]);
		}
	}

}
