import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] numbers;
	// [덧셈, 뺄셈, 곱셈, 나눗셈]
	static int[] op = new int[4];
	static int[] opUsed = new int[4];
	
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 숫자 개수 입력받기
		N = Integer.parseInt(br.readLine());
		
		// 숫자 입력받기
		numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		// 연산자 입력받기
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		// 지금까지 계산된 값 (초기값은 첫번째 숫자)
		int pValue = numbers[0];
		backTracking(1, pValue);
		
		
		System.out.println(max);
		System.out.println(min);
	
	}
	
	// index: 연산할 number 위치
	// pValue: 현재까지 계산된 값
	public static void backTracking(int index, int pValue) {
		// 종료조건: index가 N & 모든 연산자 사용
		if(index==N && op[0]==opUsed[0] && op[1]==opUsed[1] && op[2]==opUsed[2] && op[3]==opUsed[3]) {
			if(pValue<min) {
				min = pValue;
			}
			if(pValue>max) {
				max = pValue;
			}
			return;
		}
		
		for(int o=0;o<4;o++) {
			if(opUsed[o]<op[o]) {
				opUsed[o]++;
				switch(o) {
					case 0:
						backTracking(index+1, pValue + numbers[index]);
						break;
					case 1:
						backTracking(index+1, pValue - numbers[index]);
						break;
					case 2:
						backTracking(index+1, pValue * numbers[index]);
						break;
					case 3:
						if(pValue<0) {
							backTracking(index+1, -((-pValue) / numbers[index]));
						} else {
							backTracking(index+1, pValue / numbers[index]);
						}
						break;
				}
				opUsed[o]--;
			}
		}
		
	}

}
