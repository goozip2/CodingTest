class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        
        numer1 *= denom2;        
        numer2 *= denom1;
        int denom = denom1 * denom2; // 기약분수 전 분모
        int numer = numer1 + numer2; // 기약분수 전 분자
        
        // numer/denom을 기약분수화
        //어떤 수로 나눴을 때, 둘 다 완전히 나누어져야함
        //numer, denom1 중 더 작은 수가 어떤 수의 최대값
        int max = 0;
        if(numer <= denom) {
            max = numer;
        } else {
            max = denom;
        }
        
        for (int i=2;i<=max;i++) {
            if((numer / i >= 1) && (numer % i == 0) && (denom / i >= 1) && (denom % i == 0)){
                numer /= i;
                denom /= i;
                i--;
                continue;
            }
        }
        int[] answer = {};
        answer = new int[2];
        answer[0] = (numer);
        answer[1] = (denom);
        return answer;
    }
}