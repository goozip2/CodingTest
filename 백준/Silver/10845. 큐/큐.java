

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int n=0;n<N;n++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch(command) {
                case("push"):
                    int x = Integer.parseInt(st.nextToken());
                    queue.offerLast(x);
                    break;
                case("pop"):
                    if(queue.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(queue.pollFirst()).append("\n");
                    }
                    break;
                case("size"):
                    sb.append(queue.size()).append("\n");
                    break;
                case("empty"):
                    sb.append(queue.isEmpty()?1:0).append("\n");
                    break;
                case("front"):
                    if(queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(queue.peek()).append("\n");
                    }
                    break;
                case("back"):
                    if(queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(queue.peekLast()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
