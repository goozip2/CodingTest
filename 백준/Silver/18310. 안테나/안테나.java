import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		ArrayList<Integer> locations = new ArrayList<>();
		for(String s: input) {
			locations.add(Integer.parseInt(s));
		}
		Collections.sort(locations);
		
		int minLocation = locations.get((N - 1) / 2);
		
		System.out.println(minLocation);
		
	}

}
