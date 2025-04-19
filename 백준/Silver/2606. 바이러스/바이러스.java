

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 완전 탐색 -> DFS -> 재귀
public class Main {
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] graph = new int[N][N];
        for(int i=0;i<N;i++) {
            Arrays.fill(graph[i], 0);
        }

        boolean[] visited = new boolean[N];
        Arrays.fill(visited, false);

        StringTokenizer st;
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            graph[s][e] = 1;
            graph[e][s] = 1;
        }

        dfs(0,graph, visited);
        System.out.println(result-1);
    }

    static void dfs(int node, int[][] graph, boolean[] visited) {
        visited[node] = true;
        result ++;
        for(int i=0;i<graph.length;i++) {
            if(graph[node][i] == 1 && !visited[i]) {
                dfs(i, graph, visited);
            }
        }
    }
}
