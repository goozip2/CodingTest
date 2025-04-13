

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] ropeArr = new int[N];
        for(int n=0;n<N;n++) {
            int currentRope = Integer.parseInt(br.readLine());
            ropeArr[n] = currentRope;
        }
        Arrays.sort(ropeArr);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int n=0;n<N;n++) {
            pq.offer(ropeArr[n]*(N-n));
        }

        System.out.println(pq.poll());
    }
}