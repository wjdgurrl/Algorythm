package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/2293
public class problem_2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        StringTokenizer st;
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= k; j++) {
                dp[j] += dp[j - coin];
            }
        }

        System.out.println(dp[k]);


    }
}
