package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/9465
public class problem_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int index = 0;
                while(st.hasMoreTokens()){
                    arr[j][index++] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[2][n]; //n번째 열 위쪽일때 dp[0][n] 아래일때 dp[1][n]
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];

            if(n > 1){
                dp[0][1] = arr[0][1] + dp[1][0];
                dp[1][1] = arr[1][1] + dp[0][0];
            }

            for (int j = 2; j < n; j++) {
                //j열 위 스티커 선택시
                // 이번 스티커 선택  + ( 이전꺼 아래스티커 vs j-2의 최대값 )
                dp[0][j] = arr[0][j] + Math.max(dp[1][j-1], Math.max(dp[0][j-2], dp[1][j-2]));
                dp[1][j] = arr[1][j] + Math.max(dp[0][j-1], Math.max(dp[1][j-2], dp[0][j-2]));
            }

            System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
        }
    }
}
