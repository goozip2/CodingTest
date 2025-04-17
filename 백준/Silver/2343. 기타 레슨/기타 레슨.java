
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int totalTime = 0;
        int maxTime = -1;
        for(int n=0;n<N;n++) {
            arr[n] = Integer.parseInt(st.nextToken());
            totalTime += arr[n];
            maxTime = Math.max(maxTime, arr[n]);
        }

        int start = maxTime;
        int end = totalTime;
        while(start <= end) {
            int mid = (start + end) / 2;
            int count = 1; // 최소 블루레이 1개부터 시작
            int sum = 0;

            for(int i=0;i<N;i++) {
                if(sum + arr[i] > mid) {
                    count++;
                    sum = arr[i];
                } else {
                    sum += arr[i];
                }
            }

            if(count > M) {
                start = mid + 1;
            } else {
                answer = mid;
                end = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
