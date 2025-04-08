import java.util.*;

class Solution {
    public String solution(String s) {
        char[] cArray = s.toCharArray();
        
        // 일단 오름차순 정렬
        Arrays.sort(cArray);
        
        String up = new String(cArray);
        
        // 최종 내림차순 정렬
        StringBuilder down = new StringBuilder(up);
        down.reverse();
        
        return down.toString();
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        
        Solution solution = new Solution();
        String answer = solution.solution(s);
        System.out.println(answer);
        
    }
}