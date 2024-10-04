package programmers;

import java.util.HashMap;
import java.util.Map;

public class course_138475 {
    public static void main(String[] args) {
        course_138475 aa = new course_138475();
        System.out.println(aa.solution(8, new int[]{1, 3, 7}));
    }

    public int[] solution(int e, int[] starts) {
        // 1 <= starts <= x <= e < 5,000,000
        // 약수 구하기
        int[] answer = new int[starts.length];
        int[][] store = new int[e + 1][2];
/*
          store[i] = 약수
          store[i][0] = 최대약수 개수
          store[i][1] = 최대약수 숫자
*/
    /*private int primeCounter(int n){

    }*/
        return answer;
    }
}