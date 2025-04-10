import java.util.Arrays;

class Solution {
    public long solution(long n) {
        String s = Long.toString(n);

        // 오름차순 정렬
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        // 내림차순 정렬
        String sortedString = new String(arr);
        StringBuilder sb = new StringBuilder(sortedString);
        sb.reverse();

        // sb 정수화
        long answer = Long.parseLong(sb.toString());
        return answer;
    }
}