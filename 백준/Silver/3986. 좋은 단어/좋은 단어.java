import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			Stack<Character> stack = new Stack<Character>();
			for(int j=0;j<s.length();j++) {
				char c = s.charAt(j);
				
				if(!stack.isEmpty() && stack.peek() == c) {
					stack.pop();
				} else { //stack이 빈 경우 + stack에 다른 문자가 들어가 있는 경우
					stack.push(c);				
				}
			}
			if(stack.isEmpty()) {
				result++;
			}
		}
		System.out.println(result);
	}

}
