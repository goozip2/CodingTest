import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] board = new char[N][N];
		
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<N;j++) {
				board[i][j] = line.charAt(j);
			}
		}
		System.out.print(QuadTree(board, 0, 0, N));
		
	}
	
	public static String QuadTree(char[][] board, int row, int col, int size) {
		if(size==1) {
			return Character.toString(board[row][col]);
		} else {
			String s1 = QuadTree(board, row, col, size/2);
			String s2 = QuadTree(board, row, col+size/2, size/2);
			String s3 = QuadTree(board, row+size/2, col, size/2);
			String s4 = QuadTree(board, row+size/2, col+size/2, size/2);
			String s = s1.concat(s2).concat(s3).concat(s4);
			if(s.equals("0000")) {
				return "0";
			} else if (s.equals("1111")) {
				return "1";
			} else {
				return "("+s+")";
			}
		}
	}

}
