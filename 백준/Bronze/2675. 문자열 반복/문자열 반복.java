

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.BufferUnderflowException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            String S = st.nextToken();
            char[] cArray = S.toCharArray();

            StringBuilder result = new StringBuilder();
            for(char c: cArray) {
                for(int i=0;i<R;i++) {
                    result.append(c);
                }
            }
            System.out.println(result);
        }
    }
}
