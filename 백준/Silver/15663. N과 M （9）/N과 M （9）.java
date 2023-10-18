import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] answer;
	static int[] arr;
	static boolean[] isUsed;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);

		N = scan.nextInt();
		M = scan.nextInt();
		// 뽑은 수열
		answer = new int[M];
		// 사용 유무
		isUsed = new boolean[N];
		// n 숫자들
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
		Arrays.sort(arr);
		
		nm(0);
		
		System.out.println(sb);
	}

	static void nm(int index) {
		if (index == M) { // 원하는 만큼 뽑았으면 탈출
			for (int i = 0; i < M; i++) {
				sb.append(answer[i]).append(" ");

			}
			sb.append("\n");
			return;
		} else {	//원하는 만큼 뽑지 못했으면
			int before = 0; // 이전에 뽑았던 값을 저장
			for (int i = 0; i < N; i++) {
				if (!isUsed[i] && before != arr[i]) {
					isUsed[i] = true;
					answer[index] = arr[i];
					before = arr[i];
					nm(index + 1);
					isUsed[i] = false;
				}
			}
		}
	}
}
