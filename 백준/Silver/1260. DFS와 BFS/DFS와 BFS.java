

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken())-1;

        boolean[] visited = new boolean[N];
        Arrays.fill(visited, false);
        int[][] graph = new int[N][N];
        for(int n=0;n<N;n++) {
            Arrays.fill(graph[n],0);
        }
        for(int m=0;m<M;m++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            graph[s][e] = 1;
            graph[e][s] = 1;
        }

        dfs(start, graph, visited, sb);
        sb.append("\n");
        Arrays.fill(visited, false);
        bfs(start, graph, visited, sb);

        System.out.println(sb);
    }

    // 깊이 우선 탐색 -> 재귀
    static void dfs(int node, int[][] graph, boolean[] visited, StringBuilder sb) {
        visited[node] = true;
        sb.append(node+1).append(" ");
        for(int next=0;next<graph.length;next++) {
            if(graph[node][next]== 1 && !visited[next]) {
                dfs(next, graph, visited, sb);
            }
        }
    }

    // 너비 우선 탐색 -> 큐 이용
    static void bfs(int start, int[][] graph, boolean[] visited, StringBuilder sb) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node+1).append(" ");
            for(int next = 0;next<graph.length;next++) {
                if(graph[node][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
