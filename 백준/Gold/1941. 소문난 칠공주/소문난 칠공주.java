import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 25명 중 7명을 랜덤하게 뽑고, 그 7명이 이어져있는지 이다솜파가 4명 이상인지 확인하는 방법
public class Main {
	
	// 클래스 변수
	static char[][] studentArr = new char[5][5];
	static boolean[][] seven = new boolean[5][5];
	static int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
	// 출력값 (소문난 칠공주 경우의 수)
	static int result = 0;
	
	public static class Loc {
		int y;
		int x;
		public Loc(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// 학생 정보 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int y=0;y<5;y++) {
			String line = br.readLine();
			for(int x=0;x<5;x++) {
				studentArr[y][x] = line.charAt(x);
			}
		}
		
		
		backTracking(0,0,0);
		System.out.println(result);
	}
	
	public static void backTracking(int studentNumber, int selectCount, int somCount) {
		// 0) 칠공주가 완성된 경우 (정상 종료조건)
		if(selectCount==7) {
			// 0-1) 이다솜파가 우위를 점한 경우
			if(somCount>=4) {
				// 연결 유무 판단 후 result 조정
				isConnected();
				return;
			}
			// 0-2) 이다솜파가 우위를 점하지 못한 경우
			else {
				return;
			}
		}
		
		// 1) 더 이상 고려할 학생이 없을 경우 (비정상 종료조건)
		if(studentNumber==25) {
			return;
		}
		
		// 2) 현재 학생(studentNumber)을 포함시키는 경우
		int nowY = studentNumber/5;
		int nowX = studentNumber%5;
		// 현재 학생 포함
		seven[nowY][nowX] = true;
		// 이다솜파가 우위인지 확인
		int somAdd = (studentArr[nowY][nowX] == 'S')? 1:0;
		backTracking(studentNumber+1, selectCount+1, somCount+somAdd);
		seven[nowY][nowX] = false;
		
		// 3) 현재 학생(studentNumber)을 포함시키지 않는 경우
		backTracking(studentNumber+1, selectCount, somCount);
		return;
	}
	
	// 선택된 7명의 학생(seven)이 연결되었는지 확인하는 함수
	public static void isConnected() {
		boolean[][] visited = new boolean[5][5];
		Queue<Loc> queue = new LinkedList<>();
		
		Loc firstLoc = findFirst();
		
		visited[firstLoc.y][firstLoc.x] = true;
		queue.add(firstLoc);
		int length = 1;
		
		while(!queue.isEmpty()) {
			Loc nowLoc = queue.poll();
			int nowY = nowLoc.y;
			int nowX = nowLoc.x;
			for(int d=0;d<dir.length;d++) {
				int nextY = nowY + dir[d][0];
				int nextX = nowX + dir[d][1];
				
				if(nextY>=0 && nextY<5 && nextX>=0 && nextX<5 && !visited[nextY][nextX] && seven[nextY][nextX]) {
					queue.add(new Loc(nextY, nextX));
					visited[nextY][nextX] = true;
					length++;
				}
			}	
		}
		if(length == 7) {
			result++;
		}
		
	}
	
	// seven에 포함된 학생 중 첫번째 학생 찾기 (bfs 시작점 찾기)
	public static Loc findFirst() {
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(seven[i][j]==true) {
					return (new Loc(i,j));
				}
			}
		}
		// 실행되지 않을 코드 (return값이 항상 존재는 해야하기에 추가한 코드)
		return (new Loc(-1,-1));
	}
}