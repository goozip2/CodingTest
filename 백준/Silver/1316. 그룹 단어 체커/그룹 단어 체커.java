

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for(int n=0;n<N;n++) {
            boolean isGroup = true;

            String word = br.readLine();
            char[] cArray = word.toCharArray();

            for(char c: cArray) {
                int startIndex = word.indexOf(c);
                int endIndex = word.lastIndexOf(c);

                if(startIndex!=endIndex) {
                    for(int middleIndex=startIndex;middleIndex<endIndex;middleIndex++){
                        if(word.charAt(middleIndex)!=c) {
                            isGroup = false;
                            break;
                        }
                    }
                }
            }
            if(isGroup) {
                result++;
            }
        }

        System.out.println(result);
    }
}
