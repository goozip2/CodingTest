import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] network;
	static boolean[] visited;
	static int virusComCount = 0;
	static int comTotal;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		comTotal = Integer.parseInt(br.readLine());
		network = new int[comTotal][comTotal];
		visited = new boolean[comTotal];
		int networkTotal = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i=0;i<networkTotal;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			network[s][e] = 1;
			network[e][s] = 1;
		}
		
		bfs();
		System.out.println(virusComCount);
	}
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		visited[0] = true;
		queue.add(0);
		while(!queue.isEmpty()) {
			int nowCom = queue.poll();
			for(int i=0;i<comTotal;i++) {
				if(visited[i] == false && network[nowCom][i]==1) {
					virusComCount++;
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}

}