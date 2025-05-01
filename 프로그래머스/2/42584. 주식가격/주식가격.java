import java.util.Arrays;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Arrays.fill(answer, 0);

        for(int left = 0;left<prices.length-1;left++) {
            int count = 0;
            for (int right = left + 1; right < prices.length; right++) {
                if (prices[left] <= prices[right]) {
                    count++;
                } else {
                    count++;
                    break;
                }
            }
            answer[left] = count;
        }
        return answer;
    }
}