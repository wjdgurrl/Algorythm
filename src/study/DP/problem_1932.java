package study.DP;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/1932
public class problem_1932 {
    private static int[][] dp;
    private static int[][] arr;
    private static int n;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        readInput(br);
        makeDP();
        System.out.println(findMax());

    }

    private static void makeDP(){
        dp[0][0] = arr[0][0];

        if(n >= 2) {
            dp[1][0] = dp[0][0] + arr[1][0];
            dp[1][1] = dp[0][0] + arr[1][1];
        }

        for(int i = 2; i < n; i++){
            for (int j = 0; j <= i; j++) {
                //끝에 도달
                if(j == i){
                    dp[i][j] = dp[i-1][j-1] + arr[i][j];
                    continue;
                }
                //맨 처음
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                    continue;
                }
                //중간
                dp[i][j] = Math.max(dp[i-1][j-1] + arr[i][j],dp[i-1][j] + arr[i][j]);
            }
        }

    }

    private static void readInput(BufferedReader br)throws IOException{
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }
    }

    private static int findMax() {
        int max = 0;
        for (int value : dp[n-1]) {
            max = Math.max(max, value);
        }
        return max;
    }
}
