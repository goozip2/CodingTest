

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 도시 개수
        int N = Integer.parseInt(br.readLine());

        // 도시 간 거리 정보 입력
        String[] stringLenArr = br.readLine().split(" ");
        int[] lenArr = new int[N-1];
        for(int i=0;i<N-1;i++){
            lenArr[i] = Integer.parseInt(stringLenArr[i]);
        }

        // 도시 별 가스 가격 정보 입력
        String[] stringCostArr = br.readLine().split(" ");
        int[] costArr = new int[N];
        for(int i=0;i<N;i++) {
            costArr[i] = Integer.parseInt(stringCostArr[i]);
        }

        long result = 0;

        long currentCost = costArr[0];
        long tempLenSum = lenArr[0];

        for(int i=1;i<N-1;i++){
            if(costArr[i]>=currentCost) {
                tempLenSum += lenArr[i];
            } else {
                result += currentCost*tempLenSum;
                currentCost = costArr[i];
                tempLenSum = lenArr[i];
            }
        }
        // 마지막 노드 결과 더해주기
        result += currentCost*tempLenSum;
        System.out.println(result);
    }
}
