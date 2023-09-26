import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		int top = 0;
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			// n을 pop할 수 있도록, n까지 넣을 수 있게 stack에 push
			if (n > top) {
				for (int j = top + 1; j <= n; j++) {
					stack.push(j);
					sb.append("+\n");
				}
				top = n;
			}
			if (stack.get(stack.size() - 1) == n) {
				stack.pop();
				sb.append("-\n");
			}
		}

		// 스택이 안비어있으면
		if (stack.size() > 0) {
			System.out.println("NO");
		} else {
			System.out.println(sb);
		}
	}

}