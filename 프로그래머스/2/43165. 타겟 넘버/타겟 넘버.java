class Solution {
    
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(0,numbers, 0, target);
        //System.out.println(answer);
        return answer;
    }
    
    static void dfs(int nowIndex, int[] numbers, int sum, int target) {
        if(nowIndex==numbers.length && sum==target) {
            answer++;
            return;
        } else {
            if(nowIndex+1<=numbers.length) {
                dfs(nowIndex+1, numbers, sum+numbers[nowIndex], target);
                dfs(nowIndex+1, numbers, sum-numbers[nowIndex], target);
            }
        }
    }
}