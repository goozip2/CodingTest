import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        long result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] treeArr = new int[N];
        int maxLen = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int n=0;n<N;n++) {
            treeArr[n] = Integer.parseInt(st.nextToken());
            maxLen = Math.max(maxLen, treeArr[n]);
        }

        long start = 0;
        long end = maxLen;
        while(start<=end) {
            long mid = start + (end-start)/2;
            long sum = 0;
            for(int x: treeArr) {
                sum += (x-mid<0?0:x-mid);
            }
            if(sum<M) {  // 나무 부족
                end = mid-1;
            } else if(sum>=M) { // 나무 낭비
                result = mid;
                start = mid+1;
            }
        }
        System.out.println(result);
    }
}
