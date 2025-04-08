import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
            Scanner scan = new Scanner(System.in);
            char input = scan.next().charAt(0);

            int result = (int) input;
            System.out.println(result);
    }
}
