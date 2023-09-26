import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		// 큐 초기화
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		// 카드 버리기
		while (queue.size() > 1) {
			queue.remove();
			queue.add(queue.remove());
		}

		// 남은 카드 출력
		System.out.println(queue.remove());

	}

}