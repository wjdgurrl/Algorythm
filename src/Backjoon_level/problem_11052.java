package Backjoon_level;

import java.util. *;
import java.io. *;

//https://www.acmicpc.net/problem/11052
public class problem_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        arr[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = arr[1];

        for (int i = 2; i < N+1; i++) {
            for (int j = 1; j < i+1; j++) {
                dp[i] = Math.max(dp[i], dp[i-j] + arr[j]);

            }
        }
        System.out.println(dp[N]);



    }
}
