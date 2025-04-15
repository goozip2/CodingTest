import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        Deque<Integer> indexStack = new ArrayDeque<>();

        for (int n = 0; n < N; n++) {
            while (!indexStack.isEmpty() && prices[indexStack.peekFirst()] > prices[n]) {
                int index = indexStack.pollFirst();
                answer[index] = n - index;
            }
            indexStack.offerFirst(n);

        }

        while(!indexStack.isEmpty()){
            int index = indexStack.pollFirst();
            answer[index] = N-1-index;
        }
        return answer;
    }
}