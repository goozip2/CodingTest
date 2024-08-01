import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	// 클래스 변수
	static int[][] map = new int[9][9];
	static ArrayList<Loc> blankArr = new ArrayList<>();
	
	// 결과값을 한번만 출력해주기 위함 (81자리의 수가 제일 작은 경우)
	static boolean end = false;
	
	// 좌표 정의 클래스 Loc
	static class Loc {
		int y;
		int x;
		public Loc(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// map 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<9;i++) {
			String line = br.readLine();
			for(int j=0;j<9;j++) {
				map[i][j] = line.charAt(j) - '0';
				if(map[i][j] == 0) {
					blankArr.add(new Loc(i,j));
				}
			}
		}
		
		// 탐색 시작 (매개변수: 현재 빈칸 위치 인덱스)
		backTracking(0);
	}
	
	public static void backTracking(int mapIndex) {
		// 1) 종료조건: mapIndex가 blankArr의 사이즈와 같아졌을 경우 (모든 빈칸 다 채운 경우) + 프로그램 종료 조건 (end == true)
		if(mapIndex == blankArr.size() && !end) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			end = true;
			return;
		}
		
		// 이미 출력한 경우 탐색 종료.
		if(end) {
			return;
		}
		
		
		// 2) 특정 빈칸 한 곳에 숫자 넣기 (조건 고려 필요 numArr 돌면서 가로, 세로, 3*3 조건 충족 유무 확인 필요)
		Loc nowLoc = blankArr.get(mapIndex);
		int y = nowLoc.y;
		int x = nowLoc.x;
		
		int yStart = -1;
		int yEnd = -1;
		int xStart = -1;
		int xEnd = -1;
		// 3*3 y 범위 구하기
		switch(y%3) {
		case 0:
			yStart = y;
			yEnd = y+2;
			break;
		case 1:
			yStart = y-1;
			yEnd = y+1;
			break;
		case 2:
			yStart = y-2;
			yEnd = y;
			break;
		}
		// 3*3 x 범위 구하기
		switch(x%3) {
		case 0:
			xStart = x;
			xEnd = x+2;
			break;
		case 1:
			xStart = x-1;
			xEnd = x+1;
			break;
		case 2:
			xStart = x-2;
			xEnd = x;
			break;
		}
		
		for(int n=1;n<=9;n++) {
			boolean rowCheck = true;
			boolean colCheck = true;
			boolean squareCheck = true;
			
			// 2-1) 3*3 조건 충족 확인
			for(int i=yStart; i<=yEnd;i++) {
				for(int j=xStart;j<=xEnd;j++) {
					if(map[i][j] == n) {
						squareCheck = false;
						break;
					}
				}
			}
			
			// 2-2) 가로 조건 충족 확인
			for(int c=0;c<9;c++) {
				if(map[y][c] == n) {
					rowCheck = false;
					break;
				}
			}
			
			// 2-3) 세로 조건 충족 확인
 	   		for(int r=0;r<9;r++) {
 	   			if(map[r][x] == n) {
 	   				colCheck = false;
 	   				break;
 	   			}
 	   		}
 	   		
 	   		// 모든 조건 충족할 경우 backTracking
 	   		if(squareCheck && rowCheck && colCheck) {
	 	   		map[nowLoc.y][nowLoc.x] = n;
	 	   		backTracking(mapIndex+1);
	 	   		map[nowLoc.y][nowLoc.x] = 0;
 	   		}
 	   		// 하나의 조건이라도 충족하지 못했을 경우 continue
 	   		else {
 	   			continue;
 	   		}
		}
		
	}

}
