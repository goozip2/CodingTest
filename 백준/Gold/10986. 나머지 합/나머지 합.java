import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long result = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		// 숫자 입력받기
		long[] arr = new long[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 구간합 배열 구하기
		long[] sumArr = new long[N];
		sumArr[0] = arr[0];
		for(int i=1;i<N;i++) {
			sumArr[i] = sumArr[i-1] + arr[i];
		}
		
		// 구간합 배열 나머지 연산 수행
		long[] remainderArr = new long[M];
		for(int i=0;i<N;i++) {
			// Java에서 나머지 연산은 양수가 아닌 음수가 될 수 있다.
			long remainder = sumArr[i] % M;
			sumArr[i] = remainder>0?remainder:remainder*(-1);
			remainderArr[(int)sumArr[i]]++;
		}
		
		// 나머지가 0인 경우 고르기 (i==j일 경우)
		result += remainderArr[0];
		
		// 나머지가 0이 아닌 경우, 조합 수행하기 (i!=j)
		for(int i=0;i<M;i++) {
			if(remainderArr[i] != 0) {
				result += (remainderArr[i]*(remainderArr[i]-1)/2);
			}
		}
		
		System.out.println(result);
	}

}