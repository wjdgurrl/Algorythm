package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/2302
public class problem_2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine()); // 0 <= M <= N
        int[] dp = new int[N + 1]; // 각 구간 경우의 수
        int[] fix = new int[M];

        for (int i = 0; i < M; i++) {
            fix[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int lastFix = 0;
        int answer = 1;

        for (int i = 0; i < M; i++) {
            int len = fix[i] - lastFix - 1; //각 좌석 사이 거리
            answer *= dp[len];
            lastFix = fix[i];
        }

        answer *= dp[N-lastFix];

        System.out.println(answer);


    }
}
