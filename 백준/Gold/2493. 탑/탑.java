import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Top {
	int num;
	int height;
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		Stack<Top> stack = new Stack<>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			Top nTop = new Top();
			nTop.num = i;
			nTop.height = Integer.parseInt(st.nextToken());
			// 첫번째 top
			if (stack.empty()) {
				sb.append("0 ");
				stack.push(nTop);
			}
			// 들어갈 top의 높이가 더 작은 경우
			else if (stack.peek().height > nTop.height) {
				sb.append(stack.peek().num + " ");
				stack.push(nTop);
			}
			// 들어갈 top의 높이가 제일 큰 경우
			// stack 전체 탐색 필요
			else {
				// 기존 top의 높이가 새로운 top의 높이보다 작을동안
				while ((!stack.empty()) && stack.peek().height < nTop.height) {
					stack.pop();
				}
				if (stack.empty()) {
					sb.append("0 ");
				} else {
					// 기존 top의 높이가 새로운 top의 높이보다 클 경우
					sb.append(stack.peek().num + " ");
				}
				stack.push(nTop);
			}
		}
		System.out.println(sb);
	}
}