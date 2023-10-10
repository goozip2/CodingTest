import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			Stack<Character> stack = new Stack<Character>();
			int result = 1;
			
			String s = br.readLine();
			for(int j=0;j<s.length();j++) {
				char c = s.charAt(j);
				if(c == '(') {
					stack.push(c);
				} else if(c == ')') {
					if(!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} else {
						result = 0;
						break;
					}
				}
			}
			if(result == 1 && stack.isEmpty()) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		System.out.print(sb);
	}
}
