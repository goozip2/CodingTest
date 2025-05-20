import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(k);
        while(true) {
            if(k%2==0) {
                k = k/2;
                nums.add(k);
            } else {
                k = k*3+1;
                nums.add(k);
            }
            if(k==1) {
                break;
            }
        }

        // 누적합 구하기
        double[] area = new double[nums.size()];
        area[0] = 0D;
        for(int i=1;i<nums.size();i++) {
            area[i] = area[i-1] + (nums.get(i-1) + nums.get(i)) / 2D;
        }

        double[] result = new double[ranges.length];
        int i=0;
        for(int[] range: ranges) {
            int left = range[0];
            int right = nums.size() + range[1] - 1;

            if(right < left || right>=nums.size() || left < 0 || left>=nums.size() || right<0) {
                result[i] = -1D;
            } else if (right == left) {
                result[i] = 0D;
            } else {
                result[i] = area[right] - area[left];
            }
            i++;
        }
        return result;
    }
}