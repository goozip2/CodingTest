import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0] - 1).add(edge[i][1] - 1);
            graph.get(edge[i][1] - 1).add(edge[i][0] - 1);
        }

        int start = 0;
        int[] depth = new int[n];
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        depth[start] = 1;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            int nowDepth = depth[now];
            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    depth[next] = nowDepth + 1;
                    queue.offer(next);
                }
            }
        }

        Arrays.sort(depth);
        int MaxLen = depth[n - 1];
        for (int x : depth) {
            if (x == MaxLen) {
                answer++;
            }
        }

        //System.out.println(answer);
        return answer;
    }
}