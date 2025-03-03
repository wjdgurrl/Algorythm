package study.GREEDY;

import java.util.*;
import java.io.*;

public class problem_2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ropes = new int[N];
        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        //로프 개수 최대부터 정렬

        Arrays.sort(ropes);

        int maxWeight = 0;

        for (int i = 0; i < N; i++) {
            int weight = ropes[i]  * (N - i);
            if (weight > maxWeight) {
                maxWeight = weight;
            }
        }
        System.out.println(maxWeight);


    }
}
