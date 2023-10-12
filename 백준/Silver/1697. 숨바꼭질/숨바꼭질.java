import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	//배열 이미 0으로 초기화되어 있음
	static int[] map = new int[100001];
	static boolean[] visited = new boolean[100001];
	
	static int younger;
	
	public static void bfs(int x) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			int next = now;
			
			for(int i=0;i<3;i++) {
				if(i==0) {
					next = now+1;
				} else if(i==1) {
					next = now-1;
				} else if(i==2) {
					next = now*2;
				}
				
				if(next<0 || next> 100000 || visited[next]) {
					continue;
				}
				queue.add(next);
				map[next] = map[now]+1;
				visited[next] = true;
				
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int subin = scan.nextInt();
		younger = scan.nextInt();
		
		visited[subin] = true;
		bfs(subin);
		System.out.println(map[younger]);
	}

}
