

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] snums = br.readLine().split(" ");
        int[] nums = new int[snums.length];
        for(int i=0;i<nums.length;i++) {
            nums[i] = Integer.parseInt(snums[i]);
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int x: nums) {
            if(x>max) {
                max = x;
            }
            if(x<min) {
                min = x;
            }
        }
        result.append(min).append(" ").append(max);
        System.out.println(result);
    }
}
