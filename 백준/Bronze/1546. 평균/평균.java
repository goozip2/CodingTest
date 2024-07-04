import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] sScore = br.readLine().split(" ");
		
		int sum = 0;
		int max = 0;
		for(int i=0;i<N;i++) {
			int x = Integer.parseInt(sScore[i]);
			if(x>max) {
				max = x;
			}
			sum += x;
		}
		
		System.out.println((sum*100.0/max)/N);
	}

}
