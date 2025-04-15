import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> results = new ArrayList<>();

        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> speedList = new LinkedList<>();
        for(int i=0;i<progresses.length;i++) {
            queue.offer(progresses[i]);
            speedList.add(speeds[i]);
        }


        int count = 0;
        while(!queue.isEmpty()) {
            for(int i=0;i<queue.size();i++) {
                queue.set(i, queue.get(i)+speedList.get(i));
            }
            while(!queue.isEmpty() && queue.peek()>=100) {
                queue.poll();
                speedList.poll();
                count++;
            }
            if(count!=0) {
                results.add(count);
                count = 0;
            }
        }

        int[] answer = new int[results.size()];
        for(int i=0;i<results.size();i++) {
            answer[i] = results.get(i);
            System.out.println(results.get(i));
        }
        return answer;
    }
}