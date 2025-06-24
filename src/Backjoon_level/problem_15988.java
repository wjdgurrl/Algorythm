package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/15988
public class problem_15988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            //dp[n] = n가지 방법으로 나타내는 방법 개수
            long[] dp = new long[1000001];
            dp[1] = 1; // 1
            dp[2] = 2; //11  2
            dp[3] = 4; //111 12 21 3
            // dp[4] = 7 // 1111 121 211 112 13 22 31
            for (int i = 4; i <= n; i++) {
                dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009;
            }
            System.out.println(dp[n]);
        }

    }
}
