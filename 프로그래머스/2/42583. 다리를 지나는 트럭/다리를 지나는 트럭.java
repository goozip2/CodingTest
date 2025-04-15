import java.util.ArrayDeque;
import java.util.Deque;

class Car {
    int index;
    int startSec;
    int weight;

    public Car(int weight, int index) {
        startSec = 0;
        this.weight = weight;
        this.index = index;
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int N = truck_weights.length;

        Car[] cars = new Car[N];
        for(int i=0;i<N;i++) {
            Car car = new Car(truck_weights[i], i);
            cars[i] = car;
        }

        Deque<Car> dq = new ArrayDeque<>();
        int currentWeightSum = 0;
        int currentCarCount = 0;
        int sec = 0;
        int inIndex = 0;

        while (!dq.isEmpty() || inIndex < N) {
            if (dq.peekFirst() != null && sec - dq.peekFirst().startSec >= bridge_length) {
                Car c = dq.pollFirst();
                currentCarCount--;
                currentWeightSum -= c.weight;
            }
            if(currentCarCount<bridge_length && inIndex < N && currentWeightSum + cars[inIndex].weight<=weight) {
                cars[inIndex].startSec = sec;
                dq.offerLast(cars[inIndex]);
                currentCarCount++;
                currentWeightSum += cars[inIndex].weight;
                inIndex++;
            }
            sec++;
        }
        //System.out.println(sec);
        return sec;
    }
}