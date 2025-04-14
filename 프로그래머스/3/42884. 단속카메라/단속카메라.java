import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (a,b) -> (a[1]-b[1]));
        
        int currentEnd = routes[0][1];
        answer++;
        for(int carNum=1;carNum<routes.length;carNum++) {
            int nextStart = routes[carNum][0];
            int nextEnd = routes[carNum][1];
            if(nextStart>currentEnd) {
                currentEnd = nextEnd;
                answer++;
            }
        }
        //System.out.println(answer);
        return answer;
    }
}