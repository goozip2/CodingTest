import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<clothes.length;i++) {
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1], 0)+1);
        }

        int answer = 1;
        for(String s: map.keySet()) {
            answer *= (map.get(s)+1);
        }
        return answer-1;
    }
}