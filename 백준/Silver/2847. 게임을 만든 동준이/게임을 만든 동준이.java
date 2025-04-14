

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int result = 0;
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = scan.nextInt();
        }
        for(int i=N-1;i>0;i--) {
            if(arr[i]<=arr[i-1]) {
                result += arr[i-1]-arr[i]+1;
                arr[i-1] = arr[i]-1;
            }
        }
        System.out.println(result);
    }
}
