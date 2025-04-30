
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for(int i=0;i<N;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int good = 0;
        for(int target = 0;target<N;target++) {
            int left = 0;
            int right = N-1;
            int sum = 0;
            while(left < right) {
                if(left == target) {
                    left++;
                    continue;
                }
                if(right == target) {
                    right--;
                    continue;
                }
                sum = nums[left]+nums[right];
                if(sum < nums[target]) {
                    left++;
                } else if (sum>nums[target]) {
                    right--;
                } else {
                    good++;
                    break;
                }
            }
        }

        System.out.println(good);
    }
}
