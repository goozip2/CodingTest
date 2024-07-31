import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static char[] alphabets;
	static ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a','e','i','o','u'));
	
	static int L;
	static int C;
	
	public static void main(String[] args) throws IOException {
		/*
		 * 조건
			1. 최소 1개의 모음
			2. 최소 2개의 자음
			3. 증가하는 순서
			4. 길이 L
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 실제 암호 길이 L 입력받기
		L = Integer.parseInt(st.nextToken());
		// 후보 알파벳 수 C 입력받기
		C = Integer.parseInt(st.nextToken());
		
		// C개의 후보 알파벳 입력받기
		st = new StringTokenizer(br.readLine());
		alphabets = new char[C];
		for(int i=0;i<C;i++) {
			alphabets[i] = st.nextToken().charAt(0);
		}
		// 후보 알파벳 저장 배열 정렬하기 (오름차순) => 3번 조건 충족
		Arrays.sort(alphabets);
		
		// (후보 알파벳 배열 인덱스 위치, 현재 문자, 모음개수, 자음개수)
		backTracking(0,"",0,0);
		
	}
	
	// backTracking 함수
	// backTracking(후보 알파벳 배열 인덱스 위치, 현재 문자열, 모음개수, 자음개수)
	public static void backTracking(int index, String password, int vowCount, int conCount) {
		// 1) 현재 문자열이 암호 길이와 같을 경우 (종료조건) => 4번 조건 충족
		if(password.length() == L) {
			// 최소 1개의 모음 & 최소 2개의 자음 => 조건 1,2 충족
			if(vowCount>=1 && conCount>=2) {
				System.out.println(password);
			}
			return;
		}
		
		// 2) 후보 알파벳 배열 인덱스가 C일 경우 (후보지는 모두 돌았지만 선택 안한 수가 많아 암호 길이에 충족하지 못한 경우)
		if(index==C) {
			return;
		}
		
		// 3-1) 이번 문자열 포함
		if(vowels.contains(alphabets[index])) {
			backTracking(index+1, password + alphabets[index], vowCount+1, conCount);
		} else {
			backTracking(index+1, password + alphabets[index], vowCount, conCount+1);
		}
		// 3-2) 이번 문자열 미포함
		backTracking(index+1, password, vowCount, conCount);
		
	}
}


