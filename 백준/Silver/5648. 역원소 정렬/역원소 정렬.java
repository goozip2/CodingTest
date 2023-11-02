import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		long[] arr = new long[N];
		
		for(int i=0;i<N;i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(scan.next());
			String reverseString = sb.reverse().toString();
			long reverseLong = Long.parseLong(reverseString);
			arr[i] = reverseLong;
		}
		
		StringBuilder result = new StringBuilder();
		Arrays.sort(arr);
		for(long i: arr) {
			result.append(i).append("\n");
		}
		System.out.print(result);
	}

}

