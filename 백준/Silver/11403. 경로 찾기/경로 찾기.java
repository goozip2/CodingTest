

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] graph = new int[N][N];
        int[][] result = new int[N][N];
        for(int x=0;x<N;x++) {
            st = new StringTokenizer(br.readLine());
            for(int y=0;y<N;y++) {
                graph[x][y] = Integer.parseInt(st.nextToken());
                result[x][y] = 0;
            }
        }

        for(int start=0;start<N;start++) {
            for(int end=0;end<N;end++) {
                boolean[] visited = new boolean[N];
                Arrays.fill(visited, false);
                boolean isRoute = false;
                isRoute = dfs(start, end, graph, visited, N, isRoute);

                if(isRoute) {
                    result[start][end] = 1;
                }
            }
        }

        for(int x=0;x<N;x++) {
            for(int y=0;y<N;y++) {
                sb.append(result[x][y]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static boolean dfs(int now, int target, int[][] graph, boolean[] visited, int N, boolean isRoute) {
        for(int next=0;next<N;next++) {
            if(graph[now][next] == 1 && !visited[next]) {
                if(next == target) {
                    isRoute = true;
                    return isRoute;
                }
                visited[next] = true;
                isRoute = dfs(next, target, graph, visited, N, isRoute);
            }
        }
        return isRoute;
    }
}
