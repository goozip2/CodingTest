import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        // 끝나는 시간 기준 오름차순 정렬
        Arrays.sort(targets, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[1] - o2[1];
                    }
                }
        );

        int currentEnd = -1;
        for(int[] arr: targets) {
            int start = arr[0];
            int end = arr[1];

            // 다음 시작이 현재 끝보다 클 경우, 추가 미사일 필요
            if(start >= currentEnd) {
                answer++;
                currentEnd = end;
            }
        }

        System.out.println(answer);
        return answer;
    }
}