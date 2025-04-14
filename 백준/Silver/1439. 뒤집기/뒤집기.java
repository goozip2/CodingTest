

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] numArr = s.toCharArray();
        int blockCount = 1;
        int currentValue = numArr[0];
        for(int i=1;i<numArr.length;i++) {
            if(numArr[i]!=currentValue) {
                blockCount++;
                currentValue = numArr[i];
            }
        }
        System.out.println(blockCount/2);
    }
}
