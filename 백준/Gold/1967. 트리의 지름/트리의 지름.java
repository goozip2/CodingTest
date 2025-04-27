

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Edge {
    int to;
    int weight;
    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Main {
    static int maxLen = 0;
    static int maxLenNode = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<List<Edge>> tree = new ArrayList<>();
        for(int i=0;i<N;i++) {
            tree.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int n=0;n<N-1;n++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken())-1;
            int child = Integer.parseInt(st.nextToken())-1;
            int weight = Integer.parseInt(st.nextToken());
            tree.get(parent).add(new Edge(child, weight));
            tree.get(child).add(new Edge(parent, weight));
        }

        boolean[] visited = new boolean[N];
        Arrays.fill(visited, false);
        dfs(0,0,tree, visited);

        Arrays.fill(visited, false);
        dfs(maxLenNode, 0, tree, visited);

        System.out.println(maxLen);
    }

    static void dfs(int node, int len, List<List<Edge>> tree, boolean[] visited) {
        visited[node] = true;
        if(len>maxLen) {
            maxLen = len;
            maxLenNode = node;
        }
        for(Edge edge: tree.get(node)) {
            if(!visited[edge.to]) {
                dfs(edge.to, len+edge.weight, tree, visited);
            }
        }
    }
}
