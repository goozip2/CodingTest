import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer="";
        Map<String, Integer> map = new HashMap<>();

        for(int p=0;p<participant.length;p++) {
            map.put(participant[p], map.getOrDefault(participant[p], 0)+1);
        }

        for(int c=0;c<completion.length;c++) {
            map.put(completion[c], map.get(completion[c])-1);
        }

        for(int i=0;i<map.size();i++) {
            if(map.get(participant[i])!=0) {
                //System.out.println(participant[i]);
                answer = participant[i];
                break;
            }
        }
        return answer;
    }
}