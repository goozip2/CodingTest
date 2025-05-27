import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer;

        if(n>s) {
            answer = new int[]{-1};
        } else {
            // n개의 수로 구성
            answer = new int[n];

            // 가장 중앙에 근접한 값
            int x = s/n;
            Arrays.fill(answer, x);

            // 나머지 값 각 원소에 더해주기 (합이 s)
            for(int i=0;i<s%n;i++) {
                answer[i]++;
            }

            // 오름차순 정렬
            Arrays.sort(answer);
        }
        return answer;
    }
}