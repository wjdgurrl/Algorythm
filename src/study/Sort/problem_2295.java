package study.Sort;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/2295
public class problem_2295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> two = new ArrayList<>(); // n*n
        int N = Integer.parseInt(br.readLine());
        int[] U = new int[N];

        for (int i = 0; i < N; i++) {
            U[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Arrays.sort(U);

        for (int i = 0; i < U.length; i++) {
            for (int j = i; j < U.length; j++) {
                two.add(U[i] + U[j]);
            }
        }
        Collections.sort(two);
        for (int i = U.length - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {

            }
        }

    }
}
