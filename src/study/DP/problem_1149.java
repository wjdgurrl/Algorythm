package study.DP;

import java.util. *;
import java.io. *;

/*
1. 테이블 정의 : dp[i][0] = i번째 집까지 칠할경우 최소값, 단 i번째 집은 빨강
              dp[i][1] = i번째 집까지 칠할경우 최소값, 단 i번째 집은 초록
              dp[i][2] = ~~, 파랑
              0,1,2는 빨 파 초 경우
2. 점화식 찾기 : dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + 빨강 비용
              dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + 초록 비용
              dp[i][2] = min(dp[i-1][1], dp[i-1][0]) + 파랑 비용
3. 초기값 정의 : dp[1][0] = 빨강
              dp[1][1] = 초록
              dp[1][2] = 파랑

*/

public class problem_1149 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine()); // 집 개수
        int[][] dp = new int[N][3]; //가격 테이블
        int[][] d = new int[N][3];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                dp[i][j] = Integer.parseInt(line[j]);
            }
        }
        d[0][0] = dp[0][0];
        d[0][1] = dp[0][1];
        d[0][2] = dp[0][2];

        for (int i = 1; i < N; i++) {
            d[i][0] += Math.min(d[i-1][1],d[i-1][2]) + dp[i][0];
            d[i][1] += Math.min(d[i-1][0],d[i-1][2]) + dp[i][1];
            d[i][2] += Math.min(d[i-1][0],d[i-1][1]) + dp[i][2];
        }

        int result = Math.min(d[N-1][2],(Math.min(d[N-1][0],d[N-1][1])));


        System.out.println(result);
    }
}
