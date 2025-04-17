

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        int[] T = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) {
            T[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[M];
        Arrays.fill(result, 0);
        for(int t=0;t<M;t++) {
            int target = T[t];
            int start = 0;
            int end = N-1;

            while(start<=end) {
                int mid = start+(end-start)/2;
                if(A[mid] == target) {
                    result[t] = 1;
                    break;
                } else if(A[mid]<target) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        }

        for(int x: result){
            sb.append(x).append("\n");
        }
        System.out.println(sb);

    }
}
