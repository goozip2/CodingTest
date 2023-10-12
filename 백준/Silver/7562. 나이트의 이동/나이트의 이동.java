import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static boolean[][] visited;
	static int n;
	
	static int[][] pos = {{-2,-1},{-1,-2},{1, -2},{2,-1},{-2,1},{-1,2},{2,1},{1,2}};
	static int goalX;
	static int goalY;
	
	
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			int now[] = queue.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			for(int i=0;i<pos.length;i++) {
				int nextX = nowX + pos[i][0];
				int nextY = nowY + pos[i][1];
				
				//nextX와 nextY가 범위 외부에 있는 경우
                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n)
        		    continue;
                //nextX와 nextY가 방문한 적이 있는 경우
		        if (visited[nextX][nextY])
            		continue;
            
		        //가능할 경우
                queue.add(new int[] {nextX, nextY});
                //map의 숫자를 바꾸는 방법 사용 (1이 아닌 2,3,4...)
		        map[nextX][nextY] = map[nowX][nowY] + 1;
        		visited[nextX][nextY] = true;
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//testcase 반복
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			visited = new boolean[n][n];
			
			StringTokenizer nowSt = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(nowSt.nextToken());
			int y = Integer.parseInt(nowSt.nextToken());
			
			StringTokenizer goalSt = new StringTokenizer(br.readLine());
			goalX = Integer.parseInt(goalSt.nextToken());
			goalY = Integer.parseInt(goalSt.nextToken());
			
			visited[x][y] = true;
			bfs(x, y);
			System.out.println(map[goalX][goalY]);
		}
	}

}
