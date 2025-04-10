

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++) {
            String[] input = br.readLine().split(" ");
            // 학생 수
            int N = Integer.parseInt(input[0]);
            // 점수 배열
            int[] scores = new int[N];
            // 점수 총합
            int sum = 0;
            // 평균
            float mean = 0;
            // 평균 넘는 학생 수
            int goodStudentCount = 0;

            for(int i=0;i<N;i++) {
                int x = Integer.parseInt(input[i+1]);
                scores[i] = x;
                sum += x;
            }
            mean = (float)sum/N;
            for(int score: scores) {
                if(score>mean) {
                    goodStudentCount++;
                }
            }
            float percent = (float)goodStudentCount/N*100;
            System.out.printf("%.3f%%\n", percent);
        }
    }
}