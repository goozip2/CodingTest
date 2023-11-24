import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] numbers = new int[N];

		for (int i = 0; i < N; i++) {
			numbers[i] = scan.nextInt();
		}

		ArrayList<Integer> positive = new ArrayList<Integer>();
		ArrayList<Integer> negetive = new ArrayList<Integer>();

		for (int i : numbers) {
			if (i > 0) {
				positive.add(i);
			} else {
				negetive.add(i);
			}
		}

		Collections.sort(positive, Collections.reverseOrder());
		Collections.sort(negetive);

		int result = 0;

		for (int i = 0; i < positive.size(); i++) {
			// positive 배열의 원소가 1일 경우, 곱하기 보다 더하기가 더 이득임
			// 만일 1 원소가 마지막 원소더라도 문제 없음 (인덱스 초과로 자동으로 for문 탈출)
			if (positive.get(i) == 1) {
				result += 1;
				continue;
			}
			// positive 배열의 마지막 원소일 경우, pass
			if (i == positive.size() - 1) {
				result += positive.get(i);
				break; // 생략해도 되긴함
			} else {
				if (positive.get(i + 1) == 1) {
					result += positive.get(i);
					result += positive.get(i + 1);
					i++;
					continue;
				}

				result += positive.get(i) * positive.get(i + 1);
				i++;
			}
		}

		for (int i = 0; i < negetive.size(); i++) {
			// negetive 배열의 마지막 원소일 경우, pass
			if (i == negetive.size() - 1) {
				result += negetive.get(i);
				break;
			} else {
				result += negetive.get(i) * negetive.get(i + 1);
				i++;
			}
		}
		System.out.print(result);
	}
}