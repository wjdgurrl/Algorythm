package programmers;

import java.util.*;
import java.io.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/12915
public class course_12915 {
    public static void main(String[] args) {
        course_12915 obj = new course_12915();
        System.out.println(Arrays.toString(obj.solution(new String[]{"sun", "bed", "car"}, 1)));
    }

    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        System.out.println(Arrays.toString(strings));
        answer = arrayString(strings, n);
        System.out.println(Arrays.toString(answer));


        return answer;
    }

    public String[] arrayString(String[] strings, int n) {
        String temp;
        for (int i = 0; i < strings.length - 1; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                char c1 = strings[i].charAt(n);
                char c2 = strings[j].charAt(n);

                if (c1 > c2 || (c1 == c2 && strings[i].compareTo(strings[j]) > 0)) {
                    temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                }
            }
        }
        return strings;
    }


    /*public String[] arrayString(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            if (s1.charAt(n) == s2.charAt(n)) {
                return s1.compareTo(s2); // 사전순
            } else {
                return Character.compare(s1.charAt(n), s2.charAt(n)); // n번째 문자 비교
            }
        });
        return strings;
    }*/
}
