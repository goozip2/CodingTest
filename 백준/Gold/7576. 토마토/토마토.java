
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Loc {
    int x;
    int y;
    public Loc(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        boolean success = true;
        int result = Integer.MIN_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] box = new int[N][M];
        int[][] days = new int[N][M];

        for(int i=0;i<N;i++) {
            Arrays.fill(days[i], -1);
        }

        for(int x=0;x<N;x++){
            st = new StringTokenizer(br.readLine());
            for(int y=0;y<M;y++) {
                box[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        // 1: 익음
        // 0: 안익음
        // -1: 없음
        Queue<Loc> queue = new ArrayDeque<>();
        for(int x=0;x<N;x++) {
            for(int y=0;y<M;y++) {
                if(box[x][y] == 1 && days[x][y]==-1) {
                    queue.offer(new Loc(x,y));
                    days[x][y] = 0;
                }
            }
        }

        bfs(queue, box, days);

        for(int x=0;x<N;x++) {
            for(int y=0;y<M;y++) {
                if(box[x][y] == 0 && days[x][y]==-1) {
                    success = false;
                }
                result = Math.max(result, days[x][y]);
            }
        }
        if(!success) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    static void bfs(Queue<Loc> queue, int[][] box, int[][] days) {
        while(!queue.isEmpty()) {
            Loc now = queue.poll();
            for(int i=0;i<4;i++) {
                int nextx = now.x+dx[i];
                int nexty = now.y+dy[i];
                if(nextx>=0 && nextx<box.length && nexty>=0 && nexty<box[0].length && box[nextx][nexty] == 0 && days[nextx][nexty]==-1) {
                    queue.offer(new Loc(nextx, nexty));
                    days[nextx][nexty] = days[now.x][now.y]+1;
                }
            }
        }
    }
}
