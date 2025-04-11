import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int N = citations.length;
        // 오름차순 정렬
        Arrays.sort(citations);
        int MaxH = -1;

        // h는 큰 수부터, i는 작은 수부터
        // -> count가 h를 역전하는 순간이 MaxH
        for (int h = N; h >= 0; h--) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (citations[i] >= h) {
                    count++;
                }
            }
            if (count >= h) {
                MaxH = h;
                break;
            }
        }
        return MaxH;
    }
}