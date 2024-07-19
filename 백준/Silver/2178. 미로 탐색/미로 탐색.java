import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static int n;
	static int m;
	static boolean[][] visited;
	static int[][] pos = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		visited = new boolean[n][m];
		visited[0][0] = true;
		bfs(0, 0);
		System.out.println(map[n-1][m-1]);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int now[] = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			for(int i=0; i<4; i++) {
				int nextX = nowX + pos[i][0];
				int nextY = nowY + pos[i][1];
				
						//nextX와 nextY가 범위 외부에 있는 경우
		                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
                		    continue;
		                //nextX와 nextY가 방문한 적이 있거나 막힌 길일 경우
        		        if (visited[nextX][nextY] || map[nextX][nextY] == 0)
                    		continue;
                    
        		        //가능할 경우
		                q.add(new int[] {nextX, nextY});
		                //map의 숫자를 바꾸는 방법 사용 (1이 아닌 2,3,4...)
        		        map[nextX][nextY] = map[nowX][nowY] + 1;
                		visited[nextX][nextY] = true;
			}
		}
	}
}

