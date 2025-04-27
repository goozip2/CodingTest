import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];


        List<List<Integer>> map = new ArrayList<>();
        for(int i=0;i<n;i++) {
            map.add(new ArrayList<>());
        }
        for(int[] road: roads) {
            map.get(road[0]-1).add(road[1]-1);
            map.get(road[1]-1).add(road[0]-1);
        }

        int[] len = new int[n];
        Arrays.fill(len, -1);
        
        bfs(destination-1, map, len);
        
        for(int i=0;i<sources.length;i++) {
            answer[i] = len[sources[i]-1];
        }
        return answer;
    }
    
    static void bfs(int start, List<List<Integer>> map, int[] len) {
        Queue<Integer> queue = new ArrayDeque<>();
        len[start] = 0;
        queue.offer(start);
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int next: map.get(now)) {
                if(len[next] == -1) {
                    len[next] = len[now] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}