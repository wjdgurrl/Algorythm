package study.GREEDY;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/1026
public class problem_1026 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = fillArray(N, br);
        int[] B = fillArray(N, br);
        br.close();
        Arrays.sort(A);
        Arrays.sort(B);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += A[i] * B[N-i-1];
        }
        System.out.println(ans);

    }
    public static int[] fillArray(int N,BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        return array;
    }
}
