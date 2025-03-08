package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/11653
public class problem_11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            while(N % i == 0) {
                arr.add(i);
                N /= i;
            }
        }
        for (Integer integer : arr) {
            System.out.println(integer);
        }

    }
}
