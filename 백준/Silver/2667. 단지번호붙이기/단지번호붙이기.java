
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count;

    public static void main(String[] args) throws IOException {
        List<Integer> results = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                graph[i][j] = line[j] - '0';
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    dfs(i, j, graph, visited);
                    results.add(count);
                }
            }
        }

        Collections.sort(results);
        System.out.println(results.size());
        for (int x : results) {
            System.out.println(x);
        }
    }

    static void dfs(int x, int y, int[][] graph, boolean[][] visited) {
        int N = graph.length;
        visited[x][y] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int nextx = x + dx[i];
            int nexty = y + dy[i];
            if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < N && graph[nextx][nexty] == 1 && !visited[nextx][nexty]) {
                dfs(nextx, nexty, graph, visited);
            }
        }
    }
}
