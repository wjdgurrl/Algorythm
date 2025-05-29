package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/14888
public class problem_14888 {

    private static int[] arr;
    private static int[] operator;
    private static boolean[][] visited;
    private static int N;
    private static long[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        operator = new int[4]; // + - * /
        visited = new boolean[4][N-1];
        answer = new long[]{Long.MIN_VALUE, Long.MAX_VALUE};

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        String[] cal = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(cal[i]);
        }

        dfs(1,arr[0]);
        System.out.println(answer[0] +"\n" + answer[1]);

        br.close();
    }

    //10! = > 1억 안됨 1초
    private static void dfs(int depth, long result) {
        if (depth == N) {
            answer[0] = Math.max(answer[0], result);
            answer[1] = Math.min(answer[1], result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                long nextResult = 0;
                switch (i) {
                    case 0:
                        nextResult = result + arr[depth];
                        break;
                    case 1:
                        nextResult = result - arr[depth];
                        break;
                    case 2:
                        nextResult = result * arr[depth];
                        break;
                    case 3:
                        nextResult = result / arr[depth];
                        break;
                }
                ;

                dfs(depth + 1, nextResult);

                operator[i]++;
            }

        }
    }
}
