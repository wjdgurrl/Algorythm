package study.DP;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/10844
public class problem_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10]; // [i][j] -> 자리수가 i이면서 마지막 숫자가 j인 경우
        // 2 -> 23,21 -> 234,232,212,210

        bw.write(String.valueOf(solve(dp,n)));
        bw.flush();
        br.close();


    }
    private static long solve(long[][] dp,int n) {
        dp[1][0] = 0;
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;
        dp[1][4] = 1;
        dp[1][5] = 1;
        dp[1][6] = 1;
        dp[1][7] = 1;
        dp[1][8] = 1;
        dp[1][9] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
            }
            dp[i][0] = (dp[i-1][1]) % 1000000000;
            dp[i][9] = (dp[i-1][8]) % 1000000000;
        }
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[n][i]) % 1000000000;
        }
        return sum;
    }
}
