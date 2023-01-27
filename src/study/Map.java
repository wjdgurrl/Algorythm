package study;

import java.util.HashMap;
import java.util.HashSet;

public class Map {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("one","1");
        map.put("two","2");

        System.out.println(map.get("one"));

        HashSet<String> set = new HashSet<>();
    }
}
