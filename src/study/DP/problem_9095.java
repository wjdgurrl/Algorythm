package study.DP;


import java.util.*;
import java.io.*;

public class problem_9095 {
    static int[] dp = new int[11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp[3] = 4;
        dp[2] = 2;
        dp[1] = 1;

        //1. 테이블 정의
        //D[i]를 1,2,3의 합으로 나타내는 방법의 수
        //2. 점화식 찾기
        // d[4] = 1+1+1+1, 2+1+1, 1+2+1, 3+1 -> (3을 1,2,3) + 1 , d[3]
        //          1+1+2,   2+2 -> (2를 1,2) + 2, d[2]
        //            1+3 -> ) (1을 1) + 3 , d[1]
        // d[4] = d[3]+d[2]+d[1]
        // d[i] = d[i-1]+d[i-2]+d[i-3]
        //3. 초기값 정하기
        // d[1] = 1 , d[2] = 2, d[3] = 4
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        for(int num : nums){
            System.out.println(dp(num));
        }

    }

    public static int dp(int num){
        for (int i = 4; i <= num; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[num];
    }
}
