package study.DP;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/15486
public class problem_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] times = new int[n + 1];
        int[] Prices = new int[n + 1];
        int[] dp = new int[n + 1]; // i일까지 일 할때 최고값

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            Prices[i] = Integer.parseInt(st.nextToken());
        }

        for (int i =  1; i <= n; i++) {
            //오늘 일 안하는 경우
            dp[i] = Math.max(dp[i],dp[i-1]);
            //오늘 일 하는 경우
            if(times[i] + i  <= n+1){
                dp[i + times[i] - 1] = Math.max(dp[i + times[i] -1], dp[i-1] + Prices[i]);
            }
        }

        System.out.println(dp[n]);


    }
}
