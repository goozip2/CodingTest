import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Line{
	int start;
	int end;
	public Line(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Line> lineArr = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			Line l = new Line(start, end);
			lineArr.add(l);
		}
		
		Collections.sort(lineArr, new Comparator<Line>() {
			@Override
			public int compare(Line l1, Line l2) {
				return Integer.compare(l1.start, l2.start);
			}
		});
		
		
		int presentStart = Integer.MIN_VALUE;
		int presentEnd = Integer.MIN_VALUE;
		int total = 0;
		for(Line l: lineArr) {
			if(l.start <= presentEnd) {
				presentEnd = Math.max(presentEnd, l.end);
			} else {
				total += (presentEnd-presentStart);
				presentStart = l.start;
				presentEnd = l.end;
			}
		}
		
		total += (presentEnd-presentStart);
		System.out.println(total);
	}

}
