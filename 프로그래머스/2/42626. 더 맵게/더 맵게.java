import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = scoville.length;
        for (int n = 0; n < N; n++) {
            pq.offer(scoville[n]);
        }

        while (!pq.isEmpty()) {
            if (pq.peek() >= K || pq.size() == 1) {
                break;
            }
            int food1 = pq.poll();
            int food2 = pq.poll();
            answer++;
            int sum = food1 + food2*2;
            pq.offer(sum);
        }

        if (pq.peek() < K) {
            answer = -1;
        }
        
        return answer;
    }
}