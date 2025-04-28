package study.DP;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/11055
public class problem_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr= new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i]; // 최소 자기 자신으로 시작
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) { // 증가하는 조건
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }
}
