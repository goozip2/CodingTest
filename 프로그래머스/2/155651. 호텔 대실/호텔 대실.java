import java.util.Comparator;
import java.util.PriorityQueue;

class Book {
    int start;
    int end;

    public Book(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<Book> books = new PriorityQueue<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if(o1.start == o2.start) {
                    return o1.end - o2.end;
                } else {
                    return o1.start - o2.start;
                }
            }
        });

        for(int n=0;n<book_time.length;n++) {
            String[] startTime = book_time[n][0].split(":");
            int startH = Integer.parseInt(startTime[0]);
            int startM = Integer.parseInt(startTime[1]);

            String[] endTime = book_time[n][1].split(":");
            int endH = Integer.parseInt(endTime[0]);
            int endM = Integer.parseInt(endTime[1]) + 10;

            int start = startH*60 + startM;
            int end = endH*60 + endM;
            books.offer(new Book(start, end));
        }

        PriorityQueue<Book> pq = new PriorityQueue<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.end - o2.end;
            }
        });
        while(!books.isEmpty()) {
            if(pq.isEmpty()) {
                pq.offer(books.poll());
            } else {
                if(pq.peek().end <= books.peek().start) {
                    pq.poll();
                    pq.offer(books.poll());
                } else {
                    pq.offer(books.poll());
                }
            }
            if(answer<pq.size()) {
                answer = pq.size();
            }
        }
        //System.out.println(answer);
        return answer;
    }
}