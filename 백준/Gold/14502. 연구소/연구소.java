import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int N;
	static int M;
	static class Loc {
		int y;
		int x;
		public Loc(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int[][] map;
	static ArrayList<Integer> safeZoneArr = new ArrayList<>();
	static ArrayList<Loc> zeroZoneArr = new ArrayList<>();
	static ArrayList<Loc> fireZoneArr = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int y=0;y<N;y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0;x<M;x++) {
				int n = Integer.parseInt(st.nextToken());
				map[y][x] = n;
				if(n==0) {
					zeroZoneArr.add(new Loc(y,x));
				} else if(n==2) {
					fireZoneArr.add(new Loc(y,x));
				}
			}
		}
		
		boolean[] zeroZoneVisited = new boolean[zeroZoneArr.size()];
		
		makeWall(zeroZoneArr, zeroZoneVisited, 0, zeroZoneArr.size(), 3);
		
		Collections.sort(safeZoneArr);
		System.out.println(safeZoneArr.get(safeZoneArr.size()-1));
		
	}
	
	static void makeWall(ArrayList zeroZoneArr, boolean[] zeroZoneVisited, int depth, int n, int r) {
		 if(r==0) {
			 spreadVirus();
			 return;
		 }
		 if(depth==n) {
			 return;
		 } else {
			 Loc loc = (Loc) zeroZoneArr.get(depth);
			 map[loc.y][loc.x] = 1;
			 zeroZoneVisited[depth] = true;
			 makeWall(zeroZoneArr, zeroZoneVisited, depth+1, n, r-1);
		 
			 map[loc.y][loc.x] = 0;
			 zeroZoneVisited[depth] = false;
			 makeWall(zeroZoneArr, zeroZoneVisited, depth + 1, n, r);
		 }
	}
	
	
	static void spreadVirus() {
		 int[][] tempMap = new int[N][M];
		 for(int i=0;i<map.length;i++) {
			 System.arraycopy(map[i], 0, tempMap[i], 0, tempMap[i].length);
		 }
		 
		 
		 for(Loc fire: fireZoneArr) { 
			 Queue<Loc> queue = new LinkedList<>();
			 queue.add(fire);
		 
			 while(!queue.isEmpty()) {
				 Loc now = queue.poll();
				 int nowY = now.y;
				 int nowX = now.x;
		 
				 for(int d=0;d<dir.length;d++) {
					 int nextY = nowY + dir[d][0];
					 int nextX = nowX + dir[d][1];
		 
					 if(nextY<0 || nextX<0 || nextY>=N || nextX>=M) {
						 continue;
					 }
					 if(tempMap[nextY][nextX] == 0) {
						 queue.add(new Loc(nextY, nextX));
						 tempMap[nextY][nextX] = 2;
					 }
				 }
			 }
		 }
		 countSafeZone(tempMap);
	}
	
	
	static void countSafeZone(int[][] tempMap) {
		 int safeZone = 0;
		 for(int y=0;y<N;y++) {
			 for(int x=0;x<M;x++) {
				 if(tempMap[y][x] == 0) {
					 safeZone++;
				 }
			 }
		 }
		 safeZoneArr.add(safeZone);
	}

}