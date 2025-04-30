package study.DP;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/2748
public class problem_2748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        System.out.println(fibo(n, dp));

    }
    private static long fibo(int n,long[] dp) {
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
