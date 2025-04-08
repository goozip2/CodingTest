import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        StringBuilder result = new StringBuilder();
        // 각 단어에서의 인덱스
        int index = 0;
        
        for(int i=0;i< s.length() ;i++) {
            char ch = s.charAt(i);
            
            if(ch == ' ') {
                result.append(' ');
                index = 0;
            } else {
                if(index%2==0) {
                    result.append(Character.toUpperCase(ch));
                } else {
                    result.append(Character.toLowerCase(ch));
                }
                index ++;
            }
            
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        Solution solution = new Solution();
        String result = solution.solution(str);
        System.out.println(result);
    }
}
