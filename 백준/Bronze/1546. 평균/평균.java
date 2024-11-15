import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		int subjectNumber = 0;
		double[] subjectArr;
		double maxScore = 0;
		double total = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		subjectNumber = Integer.parseInt(br.readLine());
		
		subjectArr = new double[subjectNumber];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<subjectNumber;i++) {
			subjectArr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(subjectArr);
		maxScore = subjectArr[subjectNumber-1];
		for(int i=0;i<subjectNumber;i++) {
			subjectArr[i] = subjectArr[i]/maxScore*100;
			total += subjectArr[i];
		}
		
		System.out.println(total/subjectNumber);
	}

}
