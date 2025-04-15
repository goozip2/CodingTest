import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<arr.length;i++) {
            if(dq.isEmpty()) {
                dq.offerLast(arr[i]);
            } else if(dq.peekLast() != arr[i]) {
                dq.offerLast(arr[i]);
            }
        }

        //System.out.println(dq);
        int size = dq.size();
        int[] answer = new int[size];
        for(int i=0;i<size;i++) {
            answer[i] = dq.pollFirst();
        }
        return answer;
    }
}