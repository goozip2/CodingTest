import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static char[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		arr = new char[N][N * 2 - 1]; // 꼭대기 별이 (0,N-1)에 찍힘
		for (int i = 0; i < N; i++) {
			Arrays.fill(arr[i], ' '); // 공백으로 채움
		}
		
		
		//현재 행, 현재 열, 현재 삼각형 줄
		star(0, N-1, N);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2 * N - 1; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	public static void star(int r, int c, int N) {
		if (N == 3) { // k=0인 가장 작은 삼각형일 때 별찍기
			arr[r][c] = '*';
			arr[r + 1][c - 1] = arr[r + 1][c + 1] = '*';
			arr[r + 2][c - 2] = arr[r + 2][c - 1] = arr[r + 2][c] = arr[r + 2][c + 1] = arr[r + 2][c + 2] = '*';
			return;
		} else { // 큰 삼각형 세개로 다시 쪼갬
			int size = N / 2;
			star(r, c, size); // 제일 위에 삼각형
			star(r + size, c - size, size); // 아래 왼쪽 삼각형
			star(r + size, c + size, size); // 아래 오른쪽 삼각형
		}
	}
}

