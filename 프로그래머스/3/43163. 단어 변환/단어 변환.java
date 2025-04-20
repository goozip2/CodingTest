import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean containTarget = false;
        for (String word : words) {
            if (word.equals(target)) {
                containTarget = true;
                break;
            }
        }

        if (!containTarget) {
            //System.out.println(0);
            return 0;
        }

        int N = words.length;
        int[][] graph = new int[N][N];
        int[] dist = new int[N];
        boolean[] visited = new boolean[N];
        Arrays.fill(visited, false);
        Arrays.fill(dist, 0);
        for(int i=0;i<N;i++) {
            Arrays.fill(graph[i], 0);
        }

        for (int i = 0; i < N; i++) {
            char[] word1 = words[i].toCharArray();
            for (int j = 0; j < N; j++) {
                char[] word2 = words[j].toCharArray();
                int diff = 0;
                for (int k = 0; k < word1.length; k++) {
                    if (word1[k] != (word2[k])) {
                        diff++;
                    }
                }
                if (diff == 1) {
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }


        // bfs 시작
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int diff = 0;
            for (int k = 0; k < words[i].length(); k++) {
                if (words[i].charAt(k) != begin.charAt(k)) {
                    diff++;
                }
            }
            if (diff == 1) {
                visited[i] = true;
                dist[i] = 1;
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int nowIndex = queue.poll();
            if (words[nowIndex].equals(target)) {
                //System.out.println(dist[nowIndex]);
                return dist[nowIndex];
            }
            for (int nextIndex = 0; nextIndex < N; nextIndex++) {
                if (graph[nowIndex][nextIndex] == 1 && !visited[nextIndex]) {
                    queue.offer(nextIndex);
                    visited[nextIndex] = true;
                    dist[nextIndex] = dist[nowIndex] + 1;
                }
            }
        }
        System.out.println(0);
        return 0;
    }
}