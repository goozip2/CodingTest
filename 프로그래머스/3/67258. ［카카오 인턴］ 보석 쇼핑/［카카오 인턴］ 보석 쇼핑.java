import java.util.*;

public class Solution {
    public int[] solution(String[] gems) {
        // 보석 종류
        int numTotalGemTypes = new HashSet<>(Arrays.asList(gems)).size();
        // 현재까지 쇼핑한 보석 현황
        Map<String, Integer> currentGemCounts = new HashMap<>();
        
        int minLength = Integer.MAX_VALUE;
        int[] answer = {0, gems.length - 1};
        
        int left = 0;
        
        for (int right = 0; right < gems.length; right++) {
            String currentGem = gems[right];
	        // 현재 right에 존재하는 보석 구매 (counts map에 추가)
            currentGemCounts.put(currentGem, currentGemCounts.getOrDefault(currentGem, 0) + 1);
            // 모든 보석을 구매 && 구간 모순 없음 => 정상적인 쇼핑 성공
            while (currentGemCounts.size() == numTotalGemTypes && left <= right) {
	            // 성공했을 때의 길이
                int currentLength = right - left + 1;
                // 더 짧은 구간이라면, answer와 minLength 업데이트
                if (currentLength < minLength) {
                    minLength = currentLength;
                    answer[0] = left;
                    answer[1] = right;
                }
                // 왼쪽 한칸 이동
                String leftGem = gems[left];
                currentGemCounts.put(leftGem, currentGemCounts.get(leftGem) - 1);
                // 0 이지만, delete하지 않을 경우, while 문 내부 size 비교에서 모순 
                if (currentGemCounts.get(leftGem) == 0) {
                    currentGemCounts.remove(leftGem);
                }
                left++;
            }
        }
        
        int[] result = {answer[0] + 1, answer[1] + 1};
        return result;
    }
}
