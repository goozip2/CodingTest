import java.util.Arrays;

class Solution {
    public int solution(int[] array) {
        /*
            오름차순 정렬 -> 홀수기에 n/2+1번째에 존재하는 값 return
            
            오름차순 정렬
            1. 가장 작은 값을 반복적으로 구해 순서대로 넣는 방법
            2. 일단 초기값을 넣고, 새로운 값을 추가할 때, 비교하여 끼워넣는 방법
            3. 가장 작은 값을 반복적으로 구해, 구한 가장 작은 값에 해당하는 인덱스 정보를 저장해두었다가 새 배열에 한번에 넣는 방법
        */
        
        int answer = 0;
        
        Arrays.sort(array);
        answer = array[array.length/2];
        return answer;
    }
}