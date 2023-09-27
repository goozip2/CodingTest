import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Deque<Integer> deque = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String S = st.nextToken();

			switch (S) {
			case "push_front":
				deque.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				deque.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if (deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.removeFirst());
				}
				break;
			case "pop_back":
				if (deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.removeLast());
				}
				break;
			case "size":
				System.out.println(deque.size());
				break;
			case "empty":
				if (deque.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			case "front":
				if (deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.getFirst());
				}
				break;
			case "back":
				if (deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.getLast());
				}
				break;
			}

		}
	}
}