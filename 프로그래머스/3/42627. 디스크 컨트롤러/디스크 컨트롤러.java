import java.util.Comparator;
import java.util.PriorityQueue;

class Job {
    int num;
    int start;
    int time;

    public Job(int num, int start, int time) {
        this.num = num;
        this.start = start;
        this.time = time;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int totalReturnTime = 0;

        PriorityQueue<Job> jobList = new PriorityQueue<>(Comparator.comparingInt(j -> j.start));
        for (int i = 0; i < jobs.length; i++) {
            jobList.offer(new Job(i, jobs[i][0], jobs[i][1]));
        }

        PriorityQueue<Job> diskController = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                // 소요시간 짧을수록
                int cond1 = o1.time - o2.time;
                // 요청시각 빠를수록
                int cond2 = o1.start - o2.start;
                // 작업번호 작을수록
                int cond3 = o1.num - o2.num;
                if (cond1 == 0) {
                    if (cond2 == 0) {
                        return cond3;
                    } else {
                        return cond2;
                    }
                } else {
                    return cond1;
                }
            }
        });
        int clock = 0;
        while (true) {
            if (jobList.isEmpty() && diskController.isEmpty()) {
                break;
            }
            // 시간에 따라 가능한 job 대기 큐에 넣기
            while (!jobList.isEmpty() && jobList.peek().start <= clock) {
                diskController.offer(jobList.poll());
            }
            // 대기 큐에 작업 존재하는 경우, 작업 수행
            if (!diskController.isEmpty()) {
                Job nowJob = diskController.poll();
                clock += nowJob.time;
                totalReturnTime += (clock - nowJob.start);

            }
            // 대기 큐에 작업이 없고, 아직 새 작업이 start되지 않은 경우
            else if (!jobList.isEmpty()) {
                clock++;
            }
        }

        answer = totalReturnTime / jobs.length;
        //System.out.println(answer);
        return answer;
    }
}