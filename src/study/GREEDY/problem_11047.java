package study.GREEDY;

import java.util. *;
import java.io. *;

//https://www.acmicpc.net/problem/11047
public class problem_11047 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);//종류
        int K = Integer.parseInt(input[1]);//만들어야 하는 액수
        int answer = 0;

        int[] coins = new int[N];//동전 종류들

        for (int i=0; i < N; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N-1; i >= 0; i--) {
            answer += K / coins[i];
            K %= coins[i];
        }

        System.out.println(answer);

    }
}
