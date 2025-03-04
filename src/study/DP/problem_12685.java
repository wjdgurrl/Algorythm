package study.DP;

import java.io.*;

//https://www.acmicpc.net/problem/12865
public class problem_12685 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); //물건 개수
        int[] W = new int[N+1]; //물건의 무게
        int[] V = new int[N+1]; //물건의 가치
        int K = Integer.parseInt(input[1]); //버틸 수 있ㅎ는 무게

        int dp[][] = new int[N+1][K+1];

        //가치의 최대값
        //w[0] + w[1] ..w[i] <= K
        //1. dp[i][w] = i번 물건 까지 고려하고 w의 까지 가치 , 배낭에서 최대
        //2. dp[i][w] = dp[i-1][w] //지금 i는 못 넣는 경우
        //   dp[i][w] = max(dp[i-1][w],dp[i-1][w-W[i]] + V[i]) //[물건 개수][현재까지 무게 - 지금 무게] + 현재 물건 가치
        //

        for (int i = 1; i <= N; i++) {
            String[] line = br.readLine().split(" ");
            W[i] = Integer.parseInt(line[0]);
            V[i] = Integer.parseInt(line[1]);
        }
        br.close();

        for (int i = 1; i <= N; i++) {
            for (int w =0; w <= K; w++){
                if(W[i] > w){ //현재 물건 무게가 제한 무게 이상
                    dp[i][w] = dp[i-1][w]; //이전값 유지
                }else{ //이전꺼랑 지금 넣은거 비교
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-W[i]]+V[i]);
                }
            }
        }
        System.out.println(dp[N][K]);



    }
}
