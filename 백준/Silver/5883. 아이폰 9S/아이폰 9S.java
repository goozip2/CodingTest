import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/*
 * 특정 용량을 원하는 사람을 줄에서 빼면 같은 용량 원하는 사람 연속 구간 -> 최대 길이 되는 선택
 * 사람 수 N
 * 용량 B N개
 * 
 * 중복되지 않도록 set 자료구조에 용량 종류 다 넣기
 * for문 돌려가며 용량 종류에 따른 가장 긴 구간 구하기
 * 비교하여 최대 연속 구간 길이 출력
 * 
 * 
 * set에 대해 for문 돌리기
 * 		해당 용량 제거한 temp 배열
 * 		temp 배열에 대해 가장 긴 구간 구하기
 * 			for문 돌려가며, 같은 용량일 경우 count++해서 max값 구하기
 * */


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> arrB = new ArrayList<>();
		HashSet<Integer> setB = new HashSet<>();
		
		// 배열 초기화 & set 초기화
		for(int i=0;i<N;i++) {
			int x = Integer.parseInt(br.readLine());
			arrB.add(x);
			setB.add(x);
		}
		// 최대 구간 길이 저장 변수
		int max = 0;
		
		// 집합 돌아가며, tempArr에서 특정 값(x) 삭제하기
		for(int x: setB) {
			ArrayList<Integer> tempArr = new ArrayList<>(arrB);
			// 임시 배열에서 특정 값(x) 모두 제거하기
			// for-each문 내부에서는 remove 금지
			Iterator<Integer> iterator = tempArr.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() == x) {
                    iterator.remove();
                }
            }
			// 제거된 배열에서 최대구간 길이 구하기
			int pick = -1;    //최대 길이 구하는 대상 용량 변수
			int count = 0;   //최대 길이 count 변수
			for(int y: tempArr) {
				if(y == pick) {
					count++;
				} else {
					if(count>max) {
						max = count;
					}
					pick = y;
					count = 1;
				}
			}
			if(count>max) {
				max = count;
			}
		}
		System.out.println(max);
	}
}
