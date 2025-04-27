

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n = 0; n < N; n++) {
            int in = Integer.parseInt(br.readLine());
            pq.offer(in);
        }

        while (!pq.isEmpty()) {
            if (pq.size() == 1) {
                break;
            }
            int c1 = pq.poll();
            int c2 = pq.poll();
            int sum = c1 + c2;
            answer += sum;
            pq.offer(sum);
        }
        System.out.println(answer);
    }
}
