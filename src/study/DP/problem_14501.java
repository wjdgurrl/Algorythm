package study.DP;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/14501
public class problem_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] times = new int[n + 1];
        int[] prices = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            prices[i] = Integer.parseInt(st.nextToken());
        }


        //dp[i] == i일까지 일했을 때 최고 값
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i],dp[i-1]); //오늘 일 안하는 경우

            if(i + times[i] <= n+1){ //오늘 일 하는 경우 + 퇴사일 초과 안하는 경우
                dp[i + times[i] - 1]  = Math.max(dp[i + times[i] - 1], dp[i - 1] + prices[i]);
            }
        }

        System.out.println(dp[n]);
    }
}
