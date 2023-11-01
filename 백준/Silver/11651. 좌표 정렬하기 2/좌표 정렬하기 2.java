import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Coordinate2 {
	int x;
	int y;
	
	public Coordinate2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Coordinate2[] arr = new Coordinate2[N];
		
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Coordinate2(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(arr, new Comparator<Coordinate2>() {
			@Override
			public int compare(Coordinate2 c1, Coordinate2 c2) {
				if(c1.y != c2.y)
					return c1.y - c2.y;
				else
					return c1.x - c2.x;
			}
		});
		
		for(Coordinate2 c: arr) {
			sb.append(c.x).append(" ").append(c.y).append("\n");
		}
		System.out.print(sb);
	}

}
