package study.GREEDY;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/11501
public class problem_11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            long maxPrice = 0;
            long profit = 0;

            for (int j = N-1 ; j >= 0; j--) {
                if(arr[j] > maxPrice) {
                    maxPrice = arr[j];
                }else{
                    profit += (maxPrice - arr[j]);
                }
            }

            System.out.println(profit);

        }
    }
}
