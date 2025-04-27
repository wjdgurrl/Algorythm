package study.DP;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11727
public class problem_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = readInput(br);
        int[] dp = new int[n + 1];

        dp[1] = 1;
        if (n >= 2) {
            dp[2] = 3;
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + 2 * dp[i-2]) % 10007;
        }

        System.out.println(dp[n]);
    }

    private static int readInput(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
