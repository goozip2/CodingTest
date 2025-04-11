import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int T = commands.length;
        int[] answer = new int[T];
        int i;
        int j;
        int k;


        for(int t=0;t<T;t++) {
            i = commands[t][0]-1;
            j = commands[t][1]-1;
            k = commands[t][2]-1;

            int[] copyArr = Arrays.copyOfRange(array, i, j+1);
            Arrays.sort(copyArr);
            answer[t] = copyArr[k];
        }
        return answer;
    }
}