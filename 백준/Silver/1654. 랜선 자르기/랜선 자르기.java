
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        long result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lanArr = new int[K];
        int maxLen = -1;
        for(int k=0;k<K;k++) {
            lanArr[k] = Integer.parseInt(br.readLine());
            maxLen = Math.max(maxLen, lanArr[k]);
        }

        long start = 1;
        long end = maxLen;
        while(start<=end) {
            int count = 0;
            long mid = start + (end-start)/2;
            for(int k=0;k<K;k++) {
                count += lanArr[k]/mid;
            }
            if(count>=N) {
                result = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        System.out.println(result);
    }
}
