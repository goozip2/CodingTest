
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
            Deque<Character> stack = new ArrayDeque<>();
            char[] input = br.readLine().toCharArray();
            boolean VPS = true;
            for(char c: input) {
                switch (c) {
                    case('('):
                        stack.push('(');
                        break;
                    case(')'):
                        if(stack.isEmpty()) {
                            VPS = false;
                        } else if (stack.peek()!='('){
                            VPS = false;
                        } else {
                            stack.pop();
                        }
                        break;
                }
            }
            if(VPS && stack.isEmpty()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }
}
