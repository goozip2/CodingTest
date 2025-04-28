
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int n=0;n<N;n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = N-1;
        int sum = 0;

        while(left<right) {
            sum = arr[left] + arr[right];
            if(sum > M) {
                right--;
            } else if(sum<M) {
                left++;
            } else {
                result++;
                left++;
                right--;
            }
        }
        System.out.println(result);
    }
}
