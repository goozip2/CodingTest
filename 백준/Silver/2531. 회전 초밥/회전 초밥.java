
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 벨트 위 접시 수
        int N = Integer.parseInt(st.nextToken());
        // 초밥 가지 수
        int D = Integer.parseInt(st.nextToken());
        // 연속 접시 수
        int K = Integer.parseInt(st.nextToken());
        // 쿠폰 번호
        int C = Integer.parseInt(st.nextToken());

        int[] belt = new int[N];
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[D + 1];
        Arrays.fill(count, 0);

        // 첫 선택 세팅
        int kindCount = 0;
        for(int i=0;i<K;i++) {
            if(count[belt[i]] == 0) {
                kindCount++;
            }
            count[belt[i]]++;
        }
        int cKindCount = count[C]==0?kindCount+1:kindCount;
        max = Math.max(max, cKindCount);

        // left 기준 반복
        for(int i=1;i<N;i++) {
            // 왼쪽 제거
            int left = belt[i-1];
            count[left]--;
            if(count[left]==0) {
                kindCount--;
            }

            // 오른쪽 추가
            int right = belt[(i+K-1)%N];
            if(count[right]==0) {
                kindCount++;
            }
            count[right]++;

            // 쿠폰 포함 여부 검사
            cKindCount = count[C]==0?kindCount+1:kindCount;

            // max와 kindCount 비교
            max = Math.max(max, cKindCount);
        }
        System.out.println(max);

    }
}
