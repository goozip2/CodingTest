import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static int[][] initial;
	static int whiteCount;
	static int blueCount;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		initial = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				initial[i][j] = scan.nextInt();
			}
		}
		whiteCount = 0;
		blueCount = 0;

		cut(N, 0, 0);
		System.out.println(whiteCount);
		System.out.println(blueCount);

	}

	public static void cut(int size, int r, int c) {

		//확인용
		
		int blue = 0;
		int white = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (initial[r + i][c + j] == 0) {
					white++;
				} else {
					blue++;
				}
			}
		}

		// 현재 색종이가 파란색일 경우
		if (blue == size * size) {
			blueCount++;
			return;
		}
		// 현재 색종이가 하얀색일 경우
		else if (white == size * size) {
			whiteCount++;
			return;
		} else {

			// 현재 색종이에 색이 섞여있는 경우
			cut(size / 2, r, c);
			cut(size / 2, r, c + size / 2);
			cut(size / 2, r + size / 2, c);
			cut(size / 2, r + size / 2, c + size / 2);
		}
	}

}

//1) 현재 색종이(n*n) 안 모든 수가 동일한 수인지 확인 필요
// 모두 0일 경우엔 white++
// 모두 1일 경우엔 blue++
// 2) 모두 동일한 수가 아닐 경우
// 재귀 함수 호출 필요
// cut(size/2, 0, 0)
// cut(size/2, 0, size/2)
// cut(size/2, size/2, 0)

/*
 * // =================확인용
		System.out.println();
		for (int i = 0; i < size; i++) {
			System.out.println();
			for (int j = 0; j < size; j++) {
				System.out.print(initial[r + i][c + j] + " ");
			}
		}
		System.out.println("\nwhite:" + whiteCount);
		System.out.println("blue: " + blueCount);
		// =====================확인용
 * 
 * */
// cut(size/2, size/2, size/2)
