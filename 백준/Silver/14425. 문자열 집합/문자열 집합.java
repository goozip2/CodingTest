

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set1 = new HashSet<>();
        for(int n=0;n<N;n++) {
            set1.add(br.readLine());
        }

        for(int m=0;m<M;m++) {
            String s = br.readLine();
            if(set1.contains(s)) {
                result++;
            }
        }

        System.out.println(result);
    }
}
