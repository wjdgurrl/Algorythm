package study.DP;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/1003
public class problem_1003 {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp = new int[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) System.out.println(1+" "+0);
            else if(n == 1) System.out.println(0+" "+1);
            else{
                fibonacci();
                System.out.println(dp[n][0]+" "+dp[n][1]);
            }
        }
    }

    public static void fibonacci() {
        for(int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i-2][0] + dp[i-1][0];
            dp[i][1] = dp[i-2][1] + dp[i-1][1];
        }
    }
}
