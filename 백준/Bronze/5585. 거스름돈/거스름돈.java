import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int price = Integer.parseInt(br.readLine());
		int change = 1000 - price;
		
		int count = 0;
		while(change > 0) {
			if(change>=500) {
				count++;
				change -= 500;
			} else if (change>=100) {
				count++;
				change -= 100;
			} else if (change>=50) {
				count++;
				change -= 50;
			} else if (change>=10) {
				count++;
				change -= 10;
			} else if (change>=5) {
				count++;
				change -= 5;
			} else if (change>=1) {
				count++;
				change -= 1;
			}
		}
		System.out.print(count);
		
	}
}
