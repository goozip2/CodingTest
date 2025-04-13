
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting> {
    int start;
    int end;
    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Meeting o) {
        int result = (this.end!=o.end)
                ?(this.end-o.end):(this.start-o.start);
        return result;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        int count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Meeting[] arr = new Meeting[N];
        for(int n=0;n<N;n++) {
            st = new StringTokenizer(br.readLine());
            arr[n] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);
        int nowStart = 0;
        int nowEnd = 0;
        for(int i=0;i<N;i++) {
            if(arr[i].start>=nowEnd) {
                count++;
                nowStart = arr[i].start;
                nowEnd = arr[i].end;
            }
        }
        System.out.println(count);
    }
}
