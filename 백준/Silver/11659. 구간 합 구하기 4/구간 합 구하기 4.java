import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// 데이터 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 배열 크기
		int N = Integer.parseInt(st.nextToken());
		// 구간 구하는 횟수
		int M = Integer.parseInt(st.nextToken());
		
		// 구간합 배열 정의 및 초기화
		int[] arr = new int[N+1];
		// 구간합 계산 변수
		int subtotal = 0;
		arr[0] = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			subtotal += Integer.parseInt(st.nextToken());
			arr[i] = subtotal;
		}
		
		// 구간합 구하기
		StringBuilder sb = new StringBuilder();
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			sb.append(arr[j]-arr[i-1]).append("\n");
		}
		
		System.out.println(sb);
		
	}

}

