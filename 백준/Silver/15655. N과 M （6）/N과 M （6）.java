import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb;
	static int N, M;
	static int[] arr;
	static int[] choose;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		choose = new int[M];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		//System.out.println(Arrays.toString(arr));
		
		perm(0, 0);
		System.out.println(sb);
	}
	
	public static void perm(int idx, int start) {
		if (idx>=M) {
			for (int i=0 ; i<M; i++) {
				sb.append(choose[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i=start; i<N; i++) {
			choose[idx] = arr[i];
			perm(idx+1, i+1);
		}
	}
}