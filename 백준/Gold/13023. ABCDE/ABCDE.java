

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 인접 리스트화하기!!
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<N;i++) {
            graph.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[N];

        for(int m=0;m<M;m++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        for(int start=0;start<N;start++) {
            if(result==1) {
                break;
            }
            if(!visited[start]) {
                visited[start] = true;
                dfs(start, 1, graph, visited);
                visited[start]=false;
            }
        }
        System.out.println(result);

    }

    static void dfs(int now, int depth, List<List<Integer>> graph, boolean[] visited) {
        if(result == 1 || depth>=5) {
            result = 1;
            return;
        }
        for(int next: graph.get(now)) {
            if(!visited[next]) {
                visited[next] = true;
                dfs(next, depth+1, graph, visited);
                visited[next] = false;
            }
        }
    }
}
