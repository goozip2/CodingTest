import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int minIndex = 0;
        int maxIndex = people.length-1;

        while(minIndex<maxIndex) {
            if(people[minIndex]+people[maxIndex] > limit) {
                maxIndex--;
                answer++;
            } else {
                minIndex++;
                maxIndex--;
                answer++;
            }
        }
        if(minIndex==maxIndex) {
            answer++;
        }
        //System.out.println(answer);
        return answer;
    }
}