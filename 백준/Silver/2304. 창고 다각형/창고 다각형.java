

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;


/*
 * Stack 0 0 4 4 6 6 6 6 10 10 10 10 10 10 10 10 10 10 10 10 
 * Stack 0 8 8 8 8 8 8 8 10 10 10 10 10 10 10 10 10 
 * 거꾸로 돌려서 최소값 넣기
 * */


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 기둥 개수
		int N = Integer.parseInt(br.readLine());
		// 기둥 데이터 저장
		int[] arr = new int[1000];
		Stack<Integer> rightStack = new Stack<>();
		int[] rightArr = new int[1000];
		Stack<Integer> leftStack = new Stack<>();
		int[] leftArr = new int[1000];
		int[] result = new int[1000];
		
		for(int i=0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			int location = Integer.parseInt(input[0]);
			int value = Integer.parseInt(input[1]);
			arr[location-1] = value;
		}
		
		for(int i=0;i<1000;i++) {
			if(rightStack.isEmpty()) {
				rightStack.push(arr[i]);
			}
			else if(rightStack.peek() <= arr[i]) {
				rightStack.push(arr[i]);
			}
			else {
				rightStack.push(rightStack.peek());
			}
		}
		for(int i=999;i>-1;i--) {
			rightArr[i] = rightStack.pop();
		}
		
		for(int i=999;i>-1;i--) {
			if(leftStack.isEmpty()) {
				leftStack.push(arr[i]);
			}
			else if(leftStack.peek() <= arr[i]) {
				leftStack.push(arr[i]);
			}
			else {
				leftStack.push(leftStack.peek());
			}
		}
		for(int i=0;i<1000;i++) {
			leftArr[i] = leftStack.pop();
		}
		
		
		for(int i=0;i<1000;i++) {
			result[i] = Math.min(leftArr[i], rightArr[i]);
		}
		
		int resultArea = 0;
		for(int i=0;i<1000;i++) {
			resultArea += result[i];
		}
		
		System.out.print(resultArea);
		
		
		
		
		
	}
}
