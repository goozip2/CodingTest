import java.util.Arrays;
import java.util.Scanner;

class Num{
	public Num() {
		isUsed = false;
	}
	int number;
	boolean isUsed;
}

public class Main {

	static int n,m;
	static int[] arr;
	static Num[] nums;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		
		nums = new Num[n];
		arr = new int[m];
		
		//nums 초기화
		for(int i=0;i<n;i++) {
			Num n = new Num();
			nums[i] = n;
		}
		int[] sortArr = new int[n];
		for(int i=0;i<n;i++) {
			sortArr[i] = scan.nextInt();
		}
		Arrays.sort(sortArr);
		for(int i=0;i<n;i++) {
			nums[i].number = sortArr[i];
		}
		
		nm(0);
		System.out.print(sb);
	}
	
	static void nm(int index) {
		if(index == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 0; i < n; i++) {
			// 고른 수가 새로운 수라면
			if (!nums[i].isUsed) {
				nums[i].isUsed = true;
				arr[index] = nums[i].number;
				nm(index + 1);

				// 재귀 끝나면 다시 안갔던 것처럼
				nums[i].isUsed = false;
			}
		}
	}
	

}
