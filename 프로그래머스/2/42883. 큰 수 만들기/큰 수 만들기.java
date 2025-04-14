import java.util.*;
class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            int x = number.charAt(i) - '0';

            while (!stack.isEmpty() && stack.peek() < x && k>0) {
                stack.pop();
                k--;
            }
            stack.push(x);
        }
        
        while(stack.size()> number.length()-k) {
            stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        //System.out.println(sb);
        return sb.toString();
    }
}