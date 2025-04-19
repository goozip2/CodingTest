

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N][N];
        for(int i=0;i<N;i++) {
            Arrays.fill(graph[i],0);
        }
        boolean[] visited = new boolean[N];
        Arrays.fill(visited, false);
        for(int m=0;m<M;m++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            graph[s][e] = 1;
            graph[e][s] = 1;
        }

        for(int n=0;n<N;n++) {
            if(!visited[n]) {
                dfs(n, graph, visited);
                result ++;
            }
        }
        System.out.println(result);
    }

    static void dfs(int node, int[][] graph, boolean[] visited) {
        visited[node] = true;
        for(int next=0;next<graph.length;next++) {
            if(graph[node][next] ==1 && !visited[next]) {
                dfs(next, graph, visited);
            }
        }
    }
}
