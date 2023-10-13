import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int F;
	static int G;
	static int U;
	static int D;

	static int[] map;
	static boolean[] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		F = scan.nextInt();
		int S = scan.nextInt();
		G = scan.nextInt();
		U = scan.nextInt();
		D = scan.nextInt();
		
		
		if(S == G) {
			System.out.println("0");
			return;
		}
		

		map = new int[F + 1];
		visited = new boolean[F + 1];
		visited[S] = true;

		bfs(S);
		if (map[G] == 0) {
			System.out.println("use the stairs");
			return;
		}
		System.out.println(map[G]);
		return;
	}

	public static void bfs(int x) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);

		while (!queue.isEmpty()) {
			int now = queue.poll();
			int next = now;
			for (int i = 0; i < 2; i++) {
				if (i == 0) {
					next = now + U;
				} else if (i == 1) {
					next = now - D;
				}
				if (next < 1 || next > F || visited[next]) {
					continue;
				}
				queue.add(next);
				visited[next] = true;
				map[next] = map[now] + 1;
			}
		}
	}
}
//출발점과 도착점이 같은 경우에 0을 출력해줘야 하는 문제!!!
