package study.DP;

import java.util. *;
import java.io. *;

public class problem_11659 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[] input  = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        st = new StringTokenizer(br.readLine());
        int[] lists = new int[N+1]; // 수열
        int[] dp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            lists[i] = Integer.parseInt(st.nextToken());
            dp[i] = dp[i-1] + lists[i];
        }

        //dp[i] = list[1] + list[2]... + list[i]
        //dp[i-1] =dp[i] - list[i]
        //dp[i] = dp[i-1] + list[i]

        for (int i = 1; i <= M; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int I = Integer.parseInt(st.nextToken());
            int J = Integer.parseInt(st.nextToken());

            System.out.println(dp[J] - dp[I-1]);
        }



    }
}
