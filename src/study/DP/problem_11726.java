package study.DP;

import java.util. *;
import java.io. *;

/*
1. 테이블 정의 : dp[i] = 2 x i 크기의 직사각형을 채우는 방법
2. 점화식 찾기 : dp[i] = dp[i-1] + dp[i-2]
3. 초기값 정의 : dp[1] = 1, dp[2] = 2

[][][][][][]
[][][][][][]
세로로 1칸 -> n - 1칸
가로로 1칸 -> n - 2칸
d[i] = d[i-1] + d[i-2]
*/

public class problem_11726 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 2 x n의 직사각형 타일
        if (n == 1) {
            System.out.println(1);
            return;
        }

        int prev1 = 1, prev2 = 2, current = 0;
        for (int i = 3; i <= n; i++) {
            current = (prev1 + prev2) % 10007;
            prev1 = prev2;
            prev2 = current;
        }

        System.out.println(prev2);
    }
}
