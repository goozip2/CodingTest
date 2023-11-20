import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Conference {
	int start;
	int end;

	public Conference(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();

		int presentTime = 0;
		int count = 0;

		Conference[] conferenceArr = new Conference[N];

		for (int n = 0; n < N; n++) {
			Conference c = new Conference(scan.nextInt(), scan.nextInt());
			conferenceArr[n] = c;
		}

		// 1) END값 오름차순 정렬 + END값 동일할 경우, START값 오름차순 정렬
		Arrays.sort(conferenceArr, new Comparator<Conference>() {
			@Override // return 양수 -> 자리 변경
			public int compare(Conference c1, Conference c2) {
				if (c1.end != c2.end)
					return c1.end - c2.end;
				else
					return c1.start - c2.start;
			}
		});

		for (int n = 0; n < N; n++) {
			if (conferenceArr[n].start >= presentTime) {
				count++;
				presentTime = conferenceArr[n].end;
			}
		}

		System.out.print(count);

	}

}
