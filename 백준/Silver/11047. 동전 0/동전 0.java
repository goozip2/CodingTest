

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[N];
        for(int n=0;n<N;n++) {
            arr[n] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, Collections.reverseOrder());

        int count = 0;
        int change = K;
        for(int i=0;i<N;i++) {
            int tempCount = change/arr[i];
            count += tempCount;
            change -= tempCount*arr[i];
            if(change==0) {
                break;
            }
        }
        System.out.println(count);
    }
}