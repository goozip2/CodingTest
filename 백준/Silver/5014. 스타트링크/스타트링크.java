import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int topFloor;
	static int startLinkFloor;
	static int ganghoFloor;
	static int[] button = new int[2];
	static boolean[] visited;
	static int[] building;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		topFloor = Integer.parseInt(st.nextToken())-1;
		ganghoFloor = Integer.parseInt(st.nextToken())-1;
		startLinkFloor = Integer.parseInt(st.nextToken())-1;
		button[0] = Integer.parseInt(st.nextToken());
		button[1] = - Integer.parseInt(st.nextToken());
		visited = new boolean[topFloor+1];
		building = new int[topFloor+1];
		
		int result = bfs();
		if(result == -1) {
			System.out.println("use the stairs");
		} else {
			System.out.println(result);
		}
		
	}
	
	public static int bfs() {
		if(ganghoFloor == startLinkFloor) {
			return 0;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(ganghoFloor);
		visited[ganghoFloor] = true;
		while(!queue.isEmpty()) {
			int nowFloor = queue.poll();
			for(int i=0;i<2;i++) {
				int nextFloor = nowFloor + button[i];
				if(nextFloor<0 || nextFloor>topFloor) {
					continue;
				} else if (visited[nextFloor]==true) {
					continue;
				} else {
					queue.add(nextFloor);
					visited[nextFloor] = true;
					building[nextFloor] = building[nowFloor]+1;
					if(nextFloor == startLinkFloor) {
						return building[nextFloor];
					}
				}
			}
		}
		return -1;
		
	}
}