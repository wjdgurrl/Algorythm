package study;

import java.util.ArrayList;
import java.util.Arrays;
public class Arraylist {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.add("138");
        a.add("139");
        a.add("140");
        a.add(0,"150");

        System.out.println(a.get(a.size()-1));

        String[] data = {"130","131","132"};

        ArrayList<String> b = new ArrayList<>(Arrays.asList(data)); // 배열로 리스트 생성
        System.out.println(b);


    }
}
