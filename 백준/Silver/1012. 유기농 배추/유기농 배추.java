

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t=0;t<T;t++) {
            int result = 0;
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int[][] map = new int[M][N];
            boolean[][] visited = new boolean[M][N];
            for(int m=0;m<M;m++) {
                Arrays.fill(map[m], 0);
                Arrays.fill(visited[m], false);
            }
            int K = Integer.parseInt(st.nextToken());
            for(int k=0;k<K;k++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            for(int x=0;x<M;x++) {
                for(int y=0;y<N;y++) {
                    if(map[x][y] == 1 && !visited[x][y]) {
                        dfs(x,y,map, visited, M, N);
                        result++;
                    }
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int nowx, int nowy, int[][] map, boolean[][] visited, int M, int N) {
        visited[nowx][nowy] = true;
        for(int i=0;i<4;i++) {
            int nextx = nowx + dx[i];
            int nexty = nowy + dy[i];
            if(nextx>=0 && nexty>=0 && nextx<M && nexty<N && map[nextx][nexty] == 1 && !visited[nextx][nexty]) {
                visited[nextx][nexty] = true;
                dfs(nextx, nexty, map, visited, M, N);
            }
        }
    }
}
