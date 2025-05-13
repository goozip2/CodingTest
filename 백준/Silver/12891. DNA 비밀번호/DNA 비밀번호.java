
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] dna = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        int[] tBase = new int[4];
        tBase[0] = Integer.parseInt(st.nextToken());
        tBase[1] = Integer.parseInt(st.nextToken());
        tBase[2] = Integer.parseInt(st.nextToken());
        tBase[3] = Integer.parseInt(st.nextToken());

        int[] cBase = new int[4];
        Arrays.fill(cBase, 0);

        for(int i=0;i<P;i++) {
            add(dna[i], cBase);
        }
        if(check(cBase, tBase)) {
            result++;
        }
        for(int i=P;i<S;i++) {
            add(dna[i], cBase);
            delete(dna[i-P], cBase);
            if(check(cBase, tBase)) {
                result++;
            }
        }

        System.out.println(result);
    }

    public static void add(char base, int[] cBase) {
        switch (base) {
            case 'A':
                cBase[0]++;
                break;
            case 'C':
                cBase[1]++;
                break;
            case 'G':
                cBase[2]++;
                break;
            case 'T':
                cBase[3]++;
                break;
        }
    }

    public static void delete(char base, int[] cBase) {
        switch (base) {
            case 'A':
                cBase[0]--;
                break;
            case 'C':
                cBase[1]--;
                break;
            case 'G':
                cBase[2]--;
                break;
            case 'T':
                cBase[3]--;
                break;
        }
    }

    public static boolean check(int[] cBase, int[] tBase) {
        return cBase[0] >= tBase[0] && cBase[1] >= tBase[1] && cBase[2] >= tBase[2] && cBase[3] >= tBase[3];
    }
}
