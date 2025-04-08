import java.util.Scanner;

class Solution {
    public boolean solution(String str) {
        boolean answer = true;
        if(str.length()==4 || str.length()==6) {
            char[] cArray = str.toCharArray();
            for(char c: cArray){
                if(!Character.isDigit(c)) {
                    answer = false;
                } 
            } 
        } else {
            answer = false;
        }
        return answer;
    }
    public static void main(String args[]) {
        Solution s = new Solution();
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        s.solution(str);
    }
}