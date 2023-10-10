import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int piece = 0;
		//()일 경우를 어떻게 계산하지..?
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c=='(' && s.charAt(i+1) ==')') {
				i++;
				piece += stack.size();
			} else if(c=='(') {
				stack.push(c);
			} else if(c==')' && !stack.isEmpty()) {
				stack.pop();
				piece++;
			} else {
				System.out.println("wrong input");
			}
		}
		System.out.println(piece);	
	}

}
