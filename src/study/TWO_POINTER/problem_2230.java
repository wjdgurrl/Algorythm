package study.TWO_POINTER;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/2230
public class problem_2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] A = new int[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int min = Integer.MAX_VALUE;
        //A[end] - A[start]가 M이상이 되는 최초의 end를 찾기
        //1. 최초의 end 찾기 (A[end] - A[start] >= M)
        int start = 0;
        int end = 0;

        while(end < N && start < N){
            int diff = A[end] - A[start];

            if(diff >= M){
                min = Math.min(min,diff);
                start++;
            }else{
                end++;
            }
        }

        System.out.print(min);

    }
}
