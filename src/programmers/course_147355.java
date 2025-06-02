package programmers;

import java.util.*;
import java.io.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/147355?language=java
public class course_147355 {
    public static void main(String[] args) {
        course_147355 aa = new course_147355();
        System.out.println(aa.solution("3141592","271"));
    }

    public int solution(String t, String p) {
        int answer = 0;

        long pp = Long.parseLong(p);
        long len = t.length() - p.length();
        for (int i = 0; i <= len; i++) {
            long part = Long.parseLong(t.substring(i, i + p.length()));
            answer += part <= pp ? 1 : 0;
        }

        return answer;
    }
}
