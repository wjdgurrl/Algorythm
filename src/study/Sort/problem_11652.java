package study.Sort;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/11652
public class problem_11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long min_key = 0;
        int maxCount = 0;

        HashMap<Long,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num,0) +1); //키가 존재하면 +1 없으면 0
        }

        for(Map.Entry<Long,Integer> entry : map.entrySet()){
            long key = entry.getKey();
            int count = entry.getValue();

            if(count > maxCount || (count == maxCount && key < min_key)){
                maxCount = count;
                min_key = key;
            }
        }
        System.out.println(min_key);
    }
}
