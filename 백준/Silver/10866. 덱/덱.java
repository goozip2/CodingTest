

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int n=0;n<N;n++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int x;
            switch (command) {
                case("push_front"):
                    x = Integer.parseInt(st.nextToken());
                    deque.offerFirst(x);
                    break;
                case("push_back"):
                    x = Integer.parseInt(st.nextToken());
                    deque.offerLast(x);
                    break;
                case("pop_front"):
                    if(deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.pollFirst()).append("\n");
                    }
                    break;
                case("pop_back"):
                    if(deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.pollLast()).append("\n");
                    }
                    break;
                case("size"):
                    sb.append(deque.size()).append("\n");
                    break;
                case("empty"):
                    sb.append(deque.isEmpty()?1:0).append("\n");
                    break;
                case("front"):
                    if(deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.getFirst()).append("\n");
                    }
                    break;
                case("back"):
                    if(deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.getLast()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
