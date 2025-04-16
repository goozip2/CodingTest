

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<String, String> map = new HashMap<>();
        for(int n=0;n<N;n++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }

        Set<String> results = new TreeSet<>(Collections.reverseOrder());

        for(String name: map.keySet()) {
            if(map.get(name).equals("enter")) {
                results.add(name);
            }
        }

        for(String name: results){
            sb.append(name).append("\n");
        }

        System.out.println(sb);
    }
}
