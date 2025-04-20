import java.util.ArrayDeque;
import java.util.Queue;

class Loc2 {
    int x;
    int y;

    public Loc2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];
        distance[0][0] = 1;

        return bfs(0, 0, n - 1, m - 1, visited, maps, distance);
    }

    static int bfs(int startx, int starty, int targetx, int targety,
                   boolean[][] visited, int[][] maps, int[][] distance) {
        int n = maps.length;
        int m = maps[0].length;

        Queue<Loc2> queue = new ArrayDeque<>();
        queue.offer(new Loc2(startx, starty));
        visited[startx][starty] = true;

        while (!queue.isEmpty()) {
            Loc2 now = queue.poll();
            if (now.x == targetx && now.y == targety) {
                return distance[now.x][now.y];
            }
            for (int i = 0; i < 4; i++) {
                int nextx = now.x + dx[i];
                int nexty = now.y + dy[i];
                if (nextx >= 0 && nextx < n && nexty >= 0 && nexty < m &&
                    maps[nextx][nexty] == 1 && !visited[nextx][nexty]) {
                    queue.offer(new Loc2(nextx, nexty));
                    visited[nextx][nexty] = true;
                    distance[nextx][nexty] = distance[now.x][now.y] + 1;
                }
            }
        }

        return -1;
    }
}
