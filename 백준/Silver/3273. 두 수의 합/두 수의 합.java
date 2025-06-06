

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int X = Integer.parseInt(br.readLine());

        int left = 0;
        int right = N-1;
        int sum = 0;

        while(left<right) {
            sum = arr[left] + arr[right];
            if(sum < X) {
                left++;
            } else if (sum >X) {
                right--;
            } else {
                result++;
                left++;
                right--;
            }
        }
        System.out.println(result);
    }
}
