

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<N;i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            list.get(x).add(y);
            list.get(y).add(x);
        }


        findChild(0, -1, list, map);

        for(int i=1;i<N;i++) {
            sb.append(map.get(i)+1).append("\n");
        }
        System.out.println(sb);
    }

    static void findChild(int node, int parent,  List<List<Integer>> list, Map<Integer, Integer> map) {
        map.put(node, parent);
        for(int child: list.get(node)) {
            if(child!=parent) {
                findChild(child, node, list, map);
            }
        }
    }
}
