class Solution {
    public int[] solution(int n) {
        int[] answer;
        // n이 짝수라면
        if(n%2==0) {
            answer = new int[n/2];
        }
        // n이 홀수라면
        else {
            answer = new int[n/2+1];
        }
        
        int index = 0;
        for(int i=1;i<=n;i++){
            // 짝수가 아니면 (홀수라면)
            if(i%2!=0) {
                answer[index] = i;
                index++;
            }
        }
        return answer;
    }
    
}