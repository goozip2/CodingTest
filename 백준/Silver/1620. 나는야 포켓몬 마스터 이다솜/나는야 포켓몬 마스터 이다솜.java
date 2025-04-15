

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Character.isDigit;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> indexMap = new HashMap<>();
        Map<String, Integer> nameMap = new HashMap<>();
        for(int n=1;n<=N;n++) {
            String s = br.readLine();
            indexMap.put(n,s);
            nameMap.put(s,n);
        }

        for(int m=0;m<M;m++) {
            String s = br.readLine();
            char c = s.charAt(0);
            if(isDigit(c)) {
                int x = Integer.parseInt(s);
                sb.append(indexMap.get(x)).append("\n");
            } else {
                sb.append(nameMap.get(s)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
