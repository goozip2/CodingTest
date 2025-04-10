

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int N = 9;
        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[N];

        int maxValue = Integer.MIN_VALUE;
        int index = -1;
        for(int i=0;i<N;i++) {
            int x = Integer.parseInt(br.readLine());
            nums[i] = x;
            if(x>maxValue) {
                maxValue = x;
                index = i;
            }
        }
        result.append(maxValue).append("\n").append(index+1);

        System.out.println(result);


    }
}