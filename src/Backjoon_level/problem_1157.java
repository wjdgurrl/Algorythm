package Backjoon_level;

import java.util.*;
import java.io.*;

public class problem_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> arrr;
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<String,String> hashMap = new HashMap<>();
        String[] arr;
        int count = 0;
        String word = br.readLine();
        word = word.toUpperCase();
        arr = word.split("",word.length());
        arrr = new ArrayList<>(Arrays.asList(arr));
        for (String i : arrr) {
            for (String s : arrr) {
                if (i.equals(s)) {
                    count++;
                }
                hashMap.put(i, ("" + count));
            }
            count = 0;
            String a = i;
        }
        for (String t: hashMap.keySet()) {
            result.add(Integer.parseInt(hashMap.get(t)));
        }
        result.sort(Comparator.naturalOrder());//리스트 오름차순 정렬
        if(result.get(result.size()-1).equals(result.get((result.size())-2))){
            System.out.println("?");
        }
        else{
            System.out.println(getKey(hashMap,String.valueOf(result.get(result.size()-1))));
        }
    }
    public static <K, V> K getKey(Map<K, V> map, V value) {

        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }
}

