

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] targetArr = new int[N];
        int targetIndex = 0;
        for(int i=0;i<N;i++) {
            targetArr[i] = Integer.parseInt(br.readLine());
        }
        boolean result = true;
        for(int n=1;n<=N;) {
            if(stack.isEmpty()) {
                stack.push(n);
                sb.append('+').append("\n");
                n++;
            } else if (stack.peek()<targetArr[targetIndex]) {
                stack.push(n);
                sb.append('+').append("\n");
                n++;
            } else if(stack.peek()==targetArr[targetIndex]) {
                stack.pop();
                sb.append('-').append("\n");
                targetIndex++;
            } else if(stack.peek()>targetArr[targetIndex]) {
                result = false;
                break;
            }

        }
        while(!stack.isEmpty()){
            if(stack.peek()==targetArr[targetIndex]) {
                stack.pop();
                sb.append('-').append("\n");
                targetIndex++;
            } else if(stack.peek()>targetArr[targetIndex]) {
                result = false;
                break;
            }
        }

        System.out.println(result?sb:"NO");

    }
}
