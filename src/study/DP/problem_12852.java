package study.DP;

import java.util.*;
import java.io.*;

/*
1. dp[i] = 정수 n을 1로 만드는 최소회수
   prev[i] = 숫자 i가 어떤 숫자로부터 왔는지 저장
2. dp[1] = 0 | 0
   dp[2] = 1 | 2,1
   dp[3] = 1 | 3,1
   dp[4] = 2 | 4,2,1  4,3,1
   dp[5] = 2 | 5,2,1  5,4,2,1
   */

public class problem_12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] prev = new int[N + 1]; // 경로 복원용

        dp[1] = 0;
        prev[1] = 0;

        for(int i = 2; i <= N; i++) {

            //기본적으로 1씩 뺄 경우
            dp[i] = dp[i-1] + 1;
            prev[i] = i-1;

            if(i%2 == 0 && dp[i] > dp[i/2] + 1){
                dp[i] = dp[i/2];
                prev[i] = i/2;
            }
            if (i%3 == 0 && dp[i] > dp[i/3] + 1){
                dp[i] = dp[i/3];
                prev[i] = i/3;
            }
        }
        System.out.println(dp[N]);
        int cur = N;
        while(N!=0){
            System.out.print(prev[cur]+" ");
            cur = prev[cur];
        }
    }
}
