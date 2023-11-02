import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 입력받기
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for(int i=0;i<N;i++) {
			arr[i] = br.readLine();
		}
		
		// 정렬하기
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				// 1. 길이 비교
				// 길이가 다른 경우
				if(s1.length()!=s2.length()) {
					return s1.length() - s2.length();
				}
				
				// 2. 길이가 같은 경우 && 자리 수의 합 비교
				// 자리 수의 합이 다른 경우
				int sum1 = 0;
				int sum2 = 0;
				for(int i=0;i<s1.length();i++) {
					if(Character.isDigit(s1.charAt(i))) {
						sum1 += (s1.charAt(i) - '0');
					}
				}
				for(int i=0;i<s2.length();i++) {
					if(Character.isDigit(s2.charAt(i))) {
						sum2 += (s2.charAt(i) - '0');
					}
				}
				if(sum1!=sum2) {
					return sum1 - sum2;
				}
				
				// 3. 사전 순으로 비교 (숫자가 알파벳보다 사전순으로 작음)
				return s1.compareTo(s2);
			}
		});
		
		// 출력하기
		for(String s: arr) {
			sb.append(s).append("\n");
		}
		System.out.print(sb);	
	}
}
