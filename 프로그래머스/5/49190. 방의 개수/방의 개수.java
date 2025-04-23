import java.util.*;

class Solution {
    public int solution(int[] arrows) {
        int answer = 0;
        
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        Set<String> nodes = new HashSet<>();
        Set<String> edges = new HashSet<>();

        int nowx = 0;
        int nowy = 0;
        String nowNode = nowx + ","+nowy;
        String nowEdge;
        String nowReverseEdge;
        nodes.add(nowNode);
        for(int a: arrows) {
            for(int i=0;i<2;i++) {
                int nextx = nowx+dx[a];
                int nexty = nowy+dy[a];

                nowNode = nextx + ","+nexty;
                nowEdge = nowx + ","+nowy+"-"+nextx + ","+nexty;
                nowReverseEdge = nextx + ","+nexty+"-"+nowx + ","+nowy;

                // 노드는 재방문
                // edge는 첫 방문이어야함
                if(nodes.contains(nowNode) && !edges.contains(nowEdge)) {
                    answer++;
                }
                nodes.add(nowNode);
                edges.add(nowEdge);
                edges.add(nowReverseEdge);
                
                nowx = nextx;
                nowy = nexty;
            }
        }
        //System.out.println(answer);
        return answer;
    }
}