import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int C;
	static int R;
	
	static int[][] network;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		C = Integer.parseInt(br.readLine());
		R = Integer.parseInt(br.readLine());
		
		visited = new boolean[C];
		network = new int[C][C];
		
		for(int r=0;r<R;r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			network[s][e] = 1;
			network[e][s] = 1;
		}
		
		int count = bfs();
		System.out.println(count);
	}
	
	static int bfs() {
		int virusCount = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		visited[0] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int next=0;next<C;next++) {
				if(network[now][next] == 1) {
					if(next <0 || next>=C) {
						continue;
					}
					if(visited[next] == true) {
						continue;
					}
					queue.add(next);
					virusCount++;
					visited[next] = true;
				}
			}
		}
		return virusCount;
	}
}