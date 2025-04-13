
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] ropeArr = new int[N];
        for(int n=0;n<N;n++) {
            int currentRope = Integer.parseInt(br.readLine());
            ropeArr[n] = currentRope;
        }
        Arrays.sort(ropeArr);

        int[] possibleWeightArr = new int[N];
        for(int n=0;n<N;n++) {
            possibleWeightArr[n] = ropeArr[n]*(N-n);
        }
        Arrays.sort(possibleWeightArr);
        
        System.out.println(possibleWeightArr[N-1]);
    }
}