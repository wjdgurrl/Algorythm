package study.GREEDY;

import java.util. *;
import java.io. *;

//https://www.acmicpc.net/problem/2457
public class problem_2457 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] flowers = new int[n][4];
        // 3/1 ~ 11/30 최소 한가지 이상이 피어있도록 하기
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            flowers[i][0] = Integer.parseInt(input[0]);
            flowers[i][1] = Integer.parseInt(input[1]);
            flowers[i][2] = Integer.parseInt(input[2]);
            flowers[i][3] = Integer.parseInt(input[3]);
        }

    }
}
