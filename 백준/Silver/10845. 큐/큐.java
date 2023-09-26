import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 명령어 개수 입력
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		int last = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String S = st.nextToken();
			

			switch (S) {
			case "push":
				last = Integer.parseInt(st.nextToken());
				queue.add(last);
				break;
			case "pop":
				if (queue.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(queue.remove()).append("\n");
				break;
			case "size":
				sb.append(queue.size()).append("\n");
				break;
			case "empty":
				if (queue.isEmpty())
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
				break;
			case "front":
				if (queue.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(queue.peek()).append("\n");
				break;
			case "back":
				if (queue.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(last).append("\n");
				break;
			}
		}
		System.out.println(sb);

	}
}