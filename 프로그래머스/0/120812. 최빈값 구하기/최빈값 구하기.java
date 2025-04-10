/*
    array에 저장되는 숫자값은 0 ~ 999이기에 크기가 1000인 배열 생성
    -> array를 돌면서 array값에 해당하는 새 배열의 index 값을 ++
    -> max값 찾기 (max 인덱스도 (실제 최빈값))
    -> max가 여러개인 경우 -> -1 반환
*/

class Solution {
    public int solution(int[] array) {
        
        int[] num_array = new int[1000];
        
        for(int i=0;i<array.length;i++) {
            num_array[array[i]]++;
        }
        
        int max = -1;
        int max_number = -1;
        for(int i=0;i<num_array.length;i++){
            if (max < num_array[i]) {
                max = num_array[i];
                max_number = i;
            }
        }
        
        int max_freq = 0;
        for(int i=0;i<num_array.length;i++){
            if(max == num_array[i]) {
                max_freq++;
            }
        }
        
        if(max_freq > 1)
            return -1;
        else
            return max_number;
    }
}