
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.MIN_VALUE;

        int[] scores = new int[N];
        String[] sscores = br.readLine().split(" ");

        for(int n=0;n<N;n++) {
            scores[n] = Integer.parseInt(sscores[n]);
            if(scores[n] > M) {
                M = scores[n];
            }
        }

        double newSum = 0;
        for(int score: scores) {
            newSum += ((double)score/M*100);
        }

        double newMean = (double)newSum/N;
        result.append(newMean);
        System.out.println(newMean);
    }
}
