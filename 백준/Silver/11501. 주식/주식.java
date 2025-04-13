
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            Integer[] costArr = new Integer[N];
            for(int i=0;i<N;i++) {
                costArr[i] = Integer.parseInt(st.nextToken());
            }

            int currentMax = 0;
            Long result = 0L;

            for(int i=N-1;i>=0;i--) {
                int currentCost = costArr[i];
                if(currentCost<currentMax) {
                    result += (long) currentMax - currentCost;
                } else {
                    currentMax = currentCost;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
