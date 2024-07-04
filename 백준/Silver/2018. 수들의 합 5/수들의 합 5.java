import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int count = 1; //N 포함된 상태
		int start_index = 1;
		int end_index = 1;
		int sum = 1;
		while(end_index!=N) {
			if(sum == N) {
				count++;
				end_index++;
				sum += end_index;
			} else if(sum>N) {
				sum -= start_index;
				start_index++;
			} else if(sum<N) {
				end_index++;
				sum += end_index;
			}
		}
		System.out.print(count);
	}
}