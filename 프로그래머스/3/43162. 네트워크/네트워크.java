class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++) {
            if(!visited[i]){
                answer++;
                dfs(i, visited, computers, n);
            }
        }
        return answer;
    }
    
    
    static void dfs(int node, boolean[] visited, int[][] computers, int n) {
        visited[node] = true;
        for(int next=0;next<n;next++) {
            if(!visited[next] && computers[node][next] == 1) {
                dfs(next, visited, computers, n);
            }
        }
    }
}