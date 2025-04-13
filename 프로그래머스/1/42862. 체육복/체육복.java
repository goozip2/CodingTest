import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] studentArr = new int[n];
        Arrays.fill(studentArr, 1);
        for(int reserveStudent: reserve) {
            studentArr[reserveStudent-1] = 2;
        }
        for(int lostStudent: lost){
            studentArr[lostStudent-1]--;
        }


        int answer = 0;

        for(int i=0;i<n;i++) {
            if(studentArr[i]==0) {
                if(i>0 && studentArr[i-1]==2) {
                    studentArr[i-1] = 1;
                    studentArr[i] = 1;
                } else if(i<n-1 && studentArr[i+1]==2) {
                    studentArr[i+1] = 1;
                    studentArr[i] = 1;
                }
            }
        }

        for(int student: studentArr) {
            if(student>0) {
                answer++;
            }
        }
        return answer;
    }
}