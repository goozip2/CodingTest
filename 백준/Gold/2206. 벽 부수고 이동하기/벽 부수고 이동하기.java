import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class Loc {
        int y, x, dist, breakWall;

        public Loc(int y, int x, int dist, int breakWall) {
            this.y = y;
            this.x = x;
            this.dist = dist;
            this.breakWall = breakWall;
        }
    }

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int y = 0; y < N; y++) {
            String s = br.readLine();
            for (int x = 0; x < M; x++) {
                map[y][x] = s.charAt(x) - '0';
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        Queue<Loc> queue = new LinkedList<>();
        boolean[][][] isVisited = new boolean[N][M][2]; // 벽을 부수지 않은 상태와 부순 상태를 구분

        queue.add(new Loc(0, 0, 1, 0)); // 시작점 (0,0), 거리 1, 벽을 아직 부수지 않음
        isVisited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Loc nowLoc = queue.poll();
            int nowY = nowLoc.y;
            int nowX = nowLoc.x;
            int nowDist = nowLoc.dist;
            int nowBreakWall = nowLoc.breakWall;

            // 도착점에 도달한 경우
            if (nowY == N - 1 && nowX == M - 1) {
                return nowDist;
            }

            for (int d = 0; d < dir.length; d++) {
                int nextY = nowY + dir[d][0];
                int nextX = nowX + dir[d][1];

                if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= M) {
                    continue;
                }

                // 벽을 만나지 않음
                if (map[nextY][nextX] == 0 && !isVisited[nextY][nextX][nowBreakWall]) {
                    queue.add(new Loc(nextY, nextX, nowDist + 1, nowBreakWall));
                    isVisited[nextY][nextX][nowBreakWall] = true;
                }

                // 벽을 만나고 부수지 않은 경우
                if (map[nextY][nextX] == 1 && nowBreakWall == 0 && !isVisited[nextY][nextX][1]) {
                    queue.add(new Loc(nextY, nextX, nowDist + 1, 1));
                    isVisited[nextY][nextX][1] = true;
                }
            }
        }

        return -1; // 도달할 수 없는 경우
    }
}
