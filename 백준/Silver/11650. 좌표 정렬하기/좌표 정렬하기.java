import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Coordinate {
	int x;
	int y;
	
	public Coordinate(int x, int y) {
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
		
		Coordinate[] arr = new Coordinate[N];
		
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(arr, new Comparator<Coordinate>() {
			@Override
			public int compare(Coordinate c1, Coordinate c2) {
				if(c1.x != c2.x)
					return c1.x - c2.x;
				else
					return c1.y - c2.y;
			}
		});
		
		for(Coordinate c: arr) {
			sb.append(c.x).append(" ").append(c.y).append("\n");
		}
		System.out.print(sb);
	}

}
