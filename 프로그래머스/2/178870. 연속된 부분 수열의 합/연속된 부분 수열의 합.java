class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;
        int sum = sequence[left];
        while(left<=right && right<sequence.length) {
            if(sum<k) {
                right++;
                if(right == sequence.length) {
                    break;
                }
                sum+=sequence[right];
            } else if (sum>k) {
                sum-=sequence[left];
                left++;
            } else {
                if(answer[1]-answer[0] > right-left) {
                    answer[0] = left;
                    answer[1] = right;
                }
                sum-=sequence[left];
                left++;
            }
        }

        //System.out.println(answer[0]+" : "+answer[1]);
        return answer;
    }
}