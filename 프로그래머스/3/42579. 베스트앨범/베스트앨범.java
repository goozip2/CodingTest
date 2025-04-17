import java.util.*;

class Music {
    int num;
    String genre;
    int plays;

    public Music(int num, String genre, int plays) {
        this.num = num;
        this.genre = genre;
        this.plays = plays;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int N = plays.length;

        Map<String, Integer> genremap = new HashMap<>();
        List<Music> musicList = new ArrayList<>();
        for(int n=0;n<N;n++) {
            genremap.put(genres[n], genremap.getOrDefault(genres[n],0)+plays[n]);
            Music m = new Music(n,genres[n], plays[n]);
            musicList.add(m);
        }
        musicList.sort(new Comparator<Music>() {
            @Override
            public int compare(Music o1, Music o2) {
                // 1. play 순으로 정렬
                // 2. num 순으로 정렬
                if(o1.plays != o2.plays) {
                    return o2.plays - o1.plays;
                } else {
                    return o1.num - o2.num;
                }
            }
        });

        List<Map.Entry<String,Integer>> list = new ArrayList<>(genremap.entrySet());
        list.sort(Map.Entry.<String,Integer>comparingByValue().reversed());

        List<Integer> tempAnswer = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: list) {
            String g = entry.getKey();
            int count = 0;
            for(Music music: musicList) {
                if(count<2 && music.genre.equals(g)) {
                    tempAnswer.add(music.num);
                    count++;
                }
            }
        }

        int[] answer = new int[tempAnswer.size()];
        for(int i=0;i<tempAnswer.size();i++) {
            answer[i] = tempAnswer.get(i);
            //System.out.println(answer[i]);
        }
        return answer;
    }
}