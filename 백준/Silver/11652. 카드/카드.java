import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int n = Integer.parseInt(br.readLine());

        // long 사용 필요 (정수 범위 ^62)
        // HashMap에 각 num(key)와 빈도수(value) 입력
        HashMap<Long, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            Long num =Long.parseLong(br.readLine());
            /* 
             * getOrDefault(key, defaultValue):
             * 		key 존재 O, key에 매핑되는 value 반환.
             * 		key 존재 X, defaultValue 반환.
             * put(key, value):
             * 		key-value 쌍 추가 (이미 존재하는 key의 경우, 나중에 put된 value가 입력)
             */
            map.put(num,map.getOrDefault(num,0)+1);
        }

        // HashMap의 value들 비교하여 max값 찾기
        int max=0;
        ArrayList<Integer> list = new ArrayList<>(map.values());
        for(Integer val : list){
            if(max<val){
                max=val;
            }
        }
        
        
        ArrayList<Long> maxList = new ArrayList<>();
        // 밸류로 키 조회하기
        for(Long key :map.keySet()){
            if(max==map.get(key)){
                maxList.add(key);
            }
        }
        Collections.sort(maxList);
        System.out.println(maxList.get(0));

    }


}