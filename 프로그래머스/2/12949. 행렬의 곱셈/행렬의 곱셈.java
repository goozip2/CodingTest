/*
    <행렬 곱 사전지식>
    - 행렬 곱 가능 조건: (m,n) * (n,p)
    - 결과 행렬 크기: (m,p)
    - 계산 방법: C[i][j] = A[i][0]*B[0][j] + A[i][1]*B[1][j] + ... + A[i][n-1]*B[n-1][j]
*/

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int row = arr1.length;
        int col = arr2[0].length;
        
        int[][] answer = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}