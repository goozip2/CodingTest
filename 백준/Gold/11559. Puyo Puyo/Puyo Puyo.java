import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static class Loc {
        int y;
        int x;
        public Loc(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // map 초기화
        char[][] map = new char[12][6];
        for (int y = 0; y < 12; y++) {
            String line = br.readLine();
            for (int x = 0; x < 6; x++) {
                map[y][x] = line.charAt(x);
            }
        }

        // 연쇄 횟수
        int result = 0;

        // 해당 cycle에서 푸요 터짐이 수행되었는가 (-> cycle이 false일 경우 게임 종료)
        boolean cycle = true;
        
        // bfs를 위한 queue
        Queue<Loc> queue = new LinkedList<>();

        // 1개의 사이클
        while (cycle) {
            cycle = false;
            // 현재 탐색된 푸요 개수 (4 이상일 경우 터짐)
            ArrayList<Loc> puyoCountArr = new ArrayList<>();
            // bfs에서 사용할 배열
            boolean[][] visited = new boolean[12][6]; // visited 배열 초기화

            // 가능한 모든 시작 좌표 탐색
            for (int y = 0; y < 12; y++) {
                for (int x = 0; x < 6; x++) {
                	// 현재 위치가 puyo일 경우
                    if (map[y][x] != '.') {
                    	// 현재 색 기억
                        char nowColor = map[y][x];
                        puyoCountArr.clear();
                        queue.clear();
                        
                        visited[y][x] = true;
                        queue.add(new Loc(y, x));

                        while (!queue.isEmpty()) {
                            Loc loc = queue.poll();
                            // 시작 위치 개수카운트 arr에 추가
                            puyoCountArr.add(loc);
                            
                            int nowY = loc.y;
                            int nowX = loc.x;

                            for (int d = 0; d < 4; d++) {
                                int nextY = nowY + dir[d][0];
                                int nextX = nowX + dir[d][1];

                                if (nextY < 0 || nextX < 0 || nextY >= 12 || nextX >= 6) {
                                    continue;
                                } else if (!visited[nextY][nextX] && map[nextY][nextX] == nowColor) {
                                    queue.add(new Loc(nextY, nextX));
                                    visited[nextY][nextX] = true;
                                }
                            }
                        }

                        if (puyoCountArr.size() >= 4) {
                            cycle = true;
                            // puyoCountArrList에 담겨있는 좌표 모두 .으로 변경
                            for (Loc loc : puyoCountArr) {
                                map[loc.y][loc.x] = '.';
                            }
                        }
                    }
                }
            } // for문 끝
            

            // 한 번의 사이클 끝낸 후
            
            if(cycle) {
            	// 중력 연산
            	for (int x = 0; x < 6; x++) {
                    for (int y = 11; y > 0; y--) {
                        if (map[y][x] == '.') {
                            int ny = y - 1;
                            while (ny >= 0 && map[ny][x] == '.') {
                                ny--;
                            }
                            if (ny >= 0) {
                                map[y][x] = map[ny][x];
                                map[ny][x] = '.';
                            }
                        }
                    }
                }

                result++;
            }
        } // while문 끝

        System.out.println(result);

    }

}
