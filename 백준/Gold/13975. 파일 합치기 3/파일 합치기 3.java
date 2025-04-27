

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            long answer = 0;
            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                long in = Integer.parseInt(st.nextToken());
                pq.offer(in);
            }
            while (!pq.isEmpty()) {
                if (pq.size() == 1) {
                    break;
                }
                long file1 = pq.poll();
                long file2 = pq.poll();
                long sum = file1 + file2;
                answer += sum;
                pq.offer(sum);
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
