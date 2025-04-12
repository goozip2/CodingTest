

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] plusGroups = br.readLine().split("-");
        int P = plusGroups.length;
        int[] plusGroupResults = new int[P];

        for(int i=0;i<P;i++) {
            String plusGroup = plusGroups[i];
            String[] nums = plusGroup.split("\\+");
            int sum = 0;
            for(String s: nums){
                sum += Integer.parseInt(s);
            }
            plusGroupResults[i] = sum;
        }
        int result = plusGroupResults[0];
        for(int i=1;i<P;i++) {
            result -= plusGroupResults[i];
        }

        System.out.println(result);

    }
}

