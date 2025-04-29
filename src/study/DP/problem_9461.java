package study.DP;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/9461
public class problem_9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TestCase = Integer.parseInt(br.readLine());
        while (TestCase-- > 0) {
            Node node = new Node(Integer.parseInt(br.readLine()));
            node.fillDp();
            node.printDp();
        }
    }
    private static class Node{
        private int n;
        private long[] dp;

        private Node(int n){
            this.n = n;
            dp = new long[n+1];
        }

        private void fillDp(){
            if (n >= 1) dp[1] = 1;
            if (n >= 2) dp[2] = 1;
            if (n >= 3) dp[3] = 1;

            for (int i = 4; i <= this.n; i++) {
                dp[i] = dp[i - 3] + dp[i - 2];
            }
        }

        private void printDp(){
            System.out.println(dp[this.n]);
        }


    }
}
