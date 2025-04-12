import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] sNumbers = new String[numbers.length];
        for(int i=0;i<numbers.length;i++) {
            sNumbers[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(sNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -((o1+o2).compareTo(o2+o1));
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String s: sNumbers) {
            if(sb.indexOf("0")==0) {
                continue;
            }
            sb.append(s);
        }
        
        return sb.toString();
    }
}