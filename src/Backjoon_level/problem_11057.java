package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/11057
public class problem_11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long count = 0;
        long[][] dp = new long[N+1][10]; //자리수가 i일때 끝자리가 j
        for(int j=0; j < 10; j++){
            dp[1][j] = 1;
        }

        if(N > 1){
            for(int i=2; i <= N; i++){
                for(int j=0; j < 10; j++){
                    for(int k=0; k<=j; k++){
                        dp[i][j] += dp[i-1][k] % 10007;
                    }

                }
            }

        }
        for(int i=0; i<10; i++){
            count += dp[N][i] % 10007;
        }
        System.out.println(count % 10007);

    }
}
