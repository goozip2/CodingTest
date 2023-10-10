import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String s = br.readLine();
			if(s.equals(".")) { //문장이 null이라면
				break; //끝
			}
			//마지막 온점이 아닐 경우 (token이 null이 아닌 경우)
			Stack<Character> stack = new Stack<Character>();
			
			int wrongBracket = 0;
			for(int i=0;i<s.length();i++) {
				char x = s.charAt(i);
				switch(x) {
					case '[':
						stack.push(x);
						break;
					case '(':
						stack.push(x);
						break;
					case ']':
						if(stack.isEmpty() || stack.peek() != '[') {
							wrongBracket = 1;
							break;
						} else {
							stack.pop();
						}
						break;
					case ')':
						if(stack.isEmpty() || stack.peek() != '(') {
							wrongBracket = 1;
							break;
						} else {
							stack.pop();
						}
						break;
					default:
						break;
				}
			}
			if(stack.isEmpty() && wrongBracket == 0) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}

}
