import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int result = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int targetIndex=0;targetIndex<N;targetIndex++) {
			
			int target = arr[targetIndex];
			
			int sum = 0;
			
			int startIndex = 0;
			int endIndex = N-1;
			if(startIndex == targetIndex) {
				startIndex++;
			} else if (endIndex== targetIndex) {
				endIndex--;
			}
			while(startIndex<endIndex && startIndex<N && endIndex>0) {
				sum = arr[startIndex] + arr[endIndex];
				if(sum == target) {
					result ++;
					break;
				} else if (sum < target) {
					startIndex++;
					if(startIndex == targetIndex) {
						startIndex++;
					}
					
				} else {
					endIndex--;
					if(endIndex == targetIndex) {
						endIndex--;
					}
				}
			}
		}
		System.out.println(result);
	}

}
