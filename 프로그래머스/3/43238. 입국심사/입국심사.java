import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;

        long minTime = 1;
        long maxTime = Long.MAX_VALUE;

        while(minTime<=maxTime) {
            long mid = minTime + (maxTime-minTime)/2;
            long total = 0;
            for(int time: times) {
                total += mid/time;
                if(total>=n) {
                    break;
                }
            }

            if(total>=n) {
                answer = Math.min(answer, mid);
                maxTime = mid-1;
            } else {
                minTime = mid+1;
            }
        }

        //System.out.println(answer);
        return answer;
    }
}