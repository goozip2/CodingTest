/*
1. n이 6의 배수라면
    => n/6개
2. n이 6의 배수가 아니라면
    6과 인원수(10)의 최소공배수 ->30
    => 해당 최소공배수/6
*/

class Solution {
    public int solution(int n) {
        int answer = 0;
        // n이 6의 배수
        if(n%6==0) {
            answer = n/6;
        }
        // n이 6의 배수가 아닌 경우
        else {
            // 최대공약수
            int max = 0;
            // 최소공배수 구하는 방법 = 두 수의 곱/최대공약수
            // 최대공약수 구하는 방법: 더 작은 수까지 for문을 돌리며, 두 수를 각각 나눴을 때 나누어 떨어지는 가장 큰 수
            for (int i=1;i<=n&&i<=6;i++) {
                if(n%i==0 && 6%i==0){
                    max = i;
                }
            }
            //최소공배수
            int min = (n*6)/max;
            answer = min/6;
        }
        return answer;
    }
}