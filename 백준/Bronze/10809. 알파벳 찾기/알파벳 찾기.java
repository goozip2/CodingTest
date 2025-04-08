import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++) {
            char alpha = (char)('a'+ i);
            int index = s.indexOf(alpha);
            sb.append(index).append(" ");
        }

        System.out.println(sb);


    }
}