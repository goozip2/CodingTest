import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Enemy {
	int power;
	int speed;
	int wisdom;
	public Enemy(int power, int speed, int wisdom) {
		this.power = power;
		this.speed = speed;
		this.wisdom = wisdom;
	}
}

public class Main {
	
	static int kcalc(ArrayList<Enemy> arr, int K) {
		int maxPower = -1;
		int maxSpeed = -1;
		int maxWisdom = -1;
		for(int i=0;i<K;i++) {
			Enemy e = arr.get(i);
			if(e.power > maxPower){
				maxPower = e.power;
			}
			if(e.speed > maxSpeed){
				maxSpeed = e.speed;
			}
			if(e.wisdom > maxWisdom){
				maxWisdom = e.wisdom;
			}
		}
		int result = maxPower + maxSpeed + maxWisdom;
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		ArrayList<Enemy> enemyArr = new ArrayList<>();
		for(int i=0;i<N;i++) {
			String[] e = br.readLine().split(" ");
			int power = Integer.parseInt(e[0]);
			int speed = Integer.parseInt(e[1]);
			int wisdom = Integer.parseInt(e[2]);
			Enemy enemy = new Enemy(power, speed, wisdom);
			enemyArr.add(enemy);
		}
		
		// 최소 스탯 변수
		int minStats = Integer.MAX_VALUE;

        // 적 병사의 능력치에 따라 정렬
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    int powerThreshold = enemyArr.get(i).power;
                    int speedThreshold = enemyArr.get(j).speed;
                    int wisdomThreshold = enemyArr.get(k).wisdom;

                    int count = 0;
                    for (Enemy e : enemyArr) {
                        if (e.power <= powerThreshold && e.speed <= speedThreshold && e.wisdom <= wisdomThreshold) {
                            count++;
                        }
                    }

                    if (count >= K) {
                        int currentStats = powerThreshold + speedThreshold + wisdomThreshold;
                        minStats = Math.min(minStats, currentStats);
                    }
                }
            }
        }
		
        System.out.print(minStats);
	}
}
