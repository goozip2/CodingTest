

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeSet<String> arr = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = o1.length() - o2.length() != 0 ? o1.length() - o2.length() : (o1.compareTo(o2));
                return result;
            }
        });
        for(int i=0;i<N;i++) {
            arr.add(br.readLine());
        }

        for(String s: arr) {
            System.out.println(s);
        }
    }
}
