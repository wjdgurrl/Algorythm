package study.DP;

import java.util. *;
import java.io. *;

//https://www.acmicpc.net/problem/2193
public class problem_2193 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n+1];

        dp[1] = 1;
        if (n >= 2) {
            dp[2] = 1;
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[n]);


    }
}
