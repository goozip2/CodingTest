

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++) {
            String s = br.readLine();
            int contiCount = 0;
            int total = 0;

            for(int i=0;i<s.length();i++) {
                if(s.charAt(i) == 'O') {
                    contiCount++;
                    total += contiCount;
                } else {
                    contiCount = 0;
                }
            }
            result.append(total).append("\n");
        }
        System.out.println(result);
    }
}
