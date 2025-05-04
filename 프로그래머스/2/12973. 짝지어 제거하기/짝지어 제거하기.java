import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Deque<Character> stack = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        for(char x: arr) {
            if(!stack.isEmpty() && stack.peek().equals(x)) {
                stack.pop();
            } else {
                stack.push(x);
            }
        }

        int answer = stack.isEmpty()?1:0;
        //System.out.println(answer);
        return answer;
    }
}