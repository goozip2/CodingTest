import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 표의 크기
		int N = Integer.parseInt(st.nextToken());
		// 합을 구해야 하는 횟수
		int M = Integer.parseInt(st.nextToken());
		
		// 표 구간합 배열 초기화
		int[][] arr = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				arr[i][j] = arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		// 합 구하기 (M번)
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int result = arr[x2][y2] - arr[x1-1][y2] - arr[x2][y1-1] + arr[x1-1][y1-1];
			System.out.println(result);
		}

	}

}


/*
 * (x1,y1) ~ (x2,y2)
 * 
 * (1,1) ~ (2,2)
 * 
 * (2,2) - (0,2) - (2,0)
 * 1 2 3 4
 * 2 3 4 5
 * 3 4 5 6
 * 7 8 9 0
 * 
 * 
 *  (1,2) ~ (3,3)
 * 
 * (0,3)까지 빼고
 * (3,1)까지 빼기
 * 
 * 가로: (x1-1, y2)
 * 세로: (x2, y1-1)
 * 
 * arr[x2][y2] - arr[x1-1][y2] - arr[x2][y1-1]
 */
