import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int N;
	static int M;
	
	// store 좌표 저장
	static ArrayList<Loc> storeArr = new ArrayList<>();
	// home 좌표 저장
	static ArrayList<Loc> homeArr = new ArrayList<>();
	
	// 각 치킨집과 각 집 사이 거리 저장 (전체 데이터)
	// chickenDistanceArr[치킨집인덱스][집인덱스] => 치킨거리
	static int[][] ChickenDistanceArr;
	
	// 선택한 치킨집 인덱스 저장 배열
	static ArrayList<Integer> choicedStore = new ArrayList<>();
	
	// 출력값
	static int result = Integer.MAX_VALUE;
	
	// 좌표 클래스
	static class Loc {
		int y;
		int x;
		public Loc(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	// 절댓값 메소드
	public static int abs(int n, int m) {
		if (n>m) {
			return n-m;
		} else {
			return m-n;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 도시 크기 입력받기
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		// 선택해야 하는 치킨집 개수 입력받기
		M = Integer.parseInt(st.nextToken());
		
		// 지도 입력받기
		// homeArr과 storeArr 데이터 추가
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					homeArr.add(new Loc(i,j));
				} else if (map[i][j]==2) {
					storeArr.add(new Loc(i,j));
				}
			}
		}
		
		// 모든 store와 모든 home에 대해 치킨거리 비교 후 저장
		ChickenDistanceArr = new int[storeArr.size()][homeArr.size()];
		for(int s=0;s<storeArr.size();s++) {
			for(int h=0;h<homeArr.size();h++) {
				Loc store = storeArr.get(s);
				Loc home = homeArr.get(h);
				int distance = abs(store.y, home.y) + abs(store.x, home.x);
				ChickenDistanceArr[s][h] = distance;
			}
		}
		
		// 치킨 m개 선택 (현재 치킨집 인덱스 전달)
		backTracking(0);
		
		System.out.println(result);

	}
	
	public static void backTracking(Integer index) {
		// 1) 현재까지 선택한 치킨집 개수가 m개인 경우 (종료 조건)
		// -> 각 집에 따른 가장 가까운 치킨집 찾기 -> cityMinDistance값에 더해주기
		// 현재 고른 치킨집만 있다는 전재하에 최소 도시치킨거리
		if(choicedStore.size() == M) {
			int cityMinDistance = 0;
			for(int h=0;h<homeArr.size();h++) {
				// 현재 선택된 home의 최소 치킨거리
				int minDistance = Integer.MAX_VALUE;
				for(int c: choicedStore) {
					if(minDistance>ChickenDistanceArr[c][h]) {
						minDistance = ChickenDistanceArr[c][h];
					}
				}
				cityMinDistance += minDistance;
			}
			if(cityMinDistance<result) {
				result = cityMinDistance;
			}
			return;
		}
		
		if(index == storeArr.size()) {
			return;
		}
		
		// 2-1) m개 다 못고른 경우 & 현재 치킨집 선택
		choicedStore.add(index);
		backTracking(index+1);
		choicedStore.remove(index);
		
		// 2-2) m개 다 못고른 경우 & 현재 치킨집 선택 X
		backTracking(index+1);
	}	

}
