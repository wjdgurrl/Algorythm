package study.DP;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/2240
public class problem_2240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int T = Integer.parseInt(input[0]); // 초
        int W = Integer.parseInt(input[1]); // 움직임
        int[] arr =new int[T + 1];
        int[] dp = new int[T + 1]; // i일까지 움직였을 때 최대 자두 개수

        for (int i = 1 ; i < arr.length ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(catchFruit(arr, W));
    }

    private static int catchFruit(int[] arr, int w){
        int[][] dp = new int[arr.length][w+1]; // i초에 w번 움직일 때 자두의 최대 개수
        int max = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j <= w; j++){
                int currentPosition;
                if(j % 2 == 0) currentPosition = 1; // 1번 트리
                else currentPosition = 2;

                if(j > 0){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]); // 자리 바꿀 때
                }
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);// 자리 안바꿀 때

                if(arr[i] == currentPosition){
                    dp[i][j]++;
                }
            }
        }
        for(int k=0; k<=w;k++){
            max = Math.max(max,dp[arr.length-1][k]);
        }

        return max;
    }

}
