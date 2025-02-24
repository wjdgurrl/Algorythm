package study.DP;

import java.util.*;
import java.io.*;


/*
초기값 정의 : i번째 계단까지 올라갈 때 밟지 않은 계단의 값의 최소값, i번째는 밟지 않음
점화식 찾기 : d[k] = math.min(d[k-2],d[k-3]) + s[k]
초기값 정의 : d[1] =s[1] , d[2] = s[2], d[3] = s[3]
*/

public class problem_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] s = new int[n+1]; // 계단 점수 배열
        int[] dp = new int[n+1]; //dp 배열
        int total  = 0; //총합

        for (int i = 1; i <= n; i++) {
            s[i] = Integer.parseInt(br.readLine());
            total += s[i];
        }

        if(n<=2){
            System.out.println(total);
            return;
        }

        dp[1] = s[1];// 1번째 계단 안밟을 때
        dp[2] = s[2]; // 2번째 계단 안밟을 때
        dp[3] = s[3]; //3번째 계단 안밟을 때

        for (int i = 4; i <= n; i++) {
            dp[i] = Math.min(dp[i-2],dp[i-3]) + s[i];
        }

        System.out.println(total - Math.min(dp[n-1],dp[n-2]));
    }
}

/*
1. 테이블 정의 :  dp[i][j] = 현재까지 j개의 계단을 밟고 i번째 계단까지 올라갔을 때 점수의 최댓값, i는 필수 ,3개는 연속 x
2. 점화식 찾기 :  dp[i][1] = max(dp[i-2][1],dp[i-2][2]) + [i]계단 점수
3. 초기값 정의 :  dp[1][1] = s[1]
dp[1][2] = 0 → 1번 계단에서 2칸 연속 밟는 경우는 없음
dp[2][1] = s[2] → 2칸 점프해서 2번 계단에 도착
dp[2][2] = s[1] + s[2] → 1 → 2번 계단 연속 밟기
  */

/*public class problem_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] s = new int[n+1]; // 계단 점수 배열
        int[][] dp = new int[n+1][3]; //dp 배열

        for (int i = 1; i <= n; i++) {
            s[i] = Integer.parseInt(br.readLine());
        }

        if(n==1){
            System.out.println(s[1]);
            return;
        }

        dp[1][1] = s[1];// 1번째 계단에 1번 연속되서 온 경우
        dp[1][2] = 0; // 1번째 계단에 2번 연속경우 없음
        dp[2][1] = s[2];
        dp[2][2] = s[1] + s[2];

        for (int i = 3; i <= n; i++) {
            dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + s[i]; //i-2번째 계단에서 최댓값을 가져와 i번째 계단을 밟음
            dp[i][2] = dp[i-1][1] + s[i]; // i-1번째 계단을 1번 연속 밟은 상태에서 i번째 계단 밟음
        };

        System.out.println(Math.max(dp[n][1], dp[n][2]));
    }
}*/
