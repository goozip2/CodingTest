import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        Arrays.fill(answer, 0);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());

        for (int n = 0; n < operations.length; n++) {
            String operation = operations[n];
            String[] in = operation.split(" ");

            String oper = in[0];
            int num = Integer.parseInt(in[1]);

            if (oper.equals("I")) {
                pq.offer(num);
                maxpq.offer(num);
            }
            else if(oper.equals("D")){
                if(pq.isEmpty()) {
                    continue;
                }
                if (num == -1) {
                    int min = pq.poll();
                    maxpq.remove(min);
                }
                else if (num==1){
                    int max = maxpq.poll();
                    pq.remove(max);
                }
            }
        }

        if (!pq.isEmpty()) {
            answer[0] = maxpq.poll();
            answer[1] = pq.poll();
        }
        //System.out.println(answer[0] + "," + answer[1]);
        return answer;
        
    }
}