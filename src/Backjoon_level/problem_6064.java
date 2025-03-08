package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/6064
public class problem_6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        /*
        * 10 12 3 9
        *  M  N x y
        *  각 년도 x:y
        *  마지막 년도 M:N
        * M = 결국 N의 윗자리
        * LCM(M,N) ,
        *  */

        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int M = Integer.parseInt(input[0]);
            int N = Integer.parseInt(input[1]);
            int x = Integer.parseInt(input[2]);
            int y = Integer.parseInt(input[3]);

            // k = k / M + x
            // K = K / N + y

        }
        br.close();


    }
}
