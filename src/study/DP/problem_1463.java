package study.DP;

import java.util.*;
import java.io.*;

public class problem_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int d[] = new int[X+1];

        d[1] = 0;

        for (int i = 2; i <= X; i++) {
            d[i] = d[i-1] + 1;// 1을 빼는 경우
            if(i % 2 == 0) d[i] = Math.min(d[i], d[i/2] + 1); //2로 나누는 경우
            if(i % 3 == 0) d[i] = Math.min(d[i], d[i/3] + 1); //3으로 나눈
        }

        System.out.println(d[X]);

    }

}
