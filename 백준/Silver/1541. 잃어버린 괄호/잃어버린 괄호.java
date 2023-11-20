import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// (-) 기호 기준으로 나눔
		String[] subStringArr = br.readLine().split("-");
		int[] subSumArr = new int[subStringArr.length];

		// subString(덧셈으로 이루어진 부분) 각각 계산
		for (int i = 0; i < subStringArr.length; i++) {
			String[] Snumbers = subStringArr[i].split("\\+");
			int[] Inumbers = new int[Snumbers.length];
			// String을 int화
			for (int j = 0; j < Snumbers.length; j++) {
				Inumbers[j] = Integer.parseInt(Snumbers[j]);
			}
			int subSum = 0;
			for (int n : Inumbers) {
				subSum += n;
			}
			subSumArr[i] = subSum;
		}

		int result = subSumArr[0];
		for (int x = 1; x < subSumArr.length; x++) {
			result -= subSumArr[x];
		}
		System.out.print(result);
	}

}
