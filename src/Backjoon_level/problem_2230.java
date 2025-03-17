package Backjoon_level;

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
        int min_diff = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int idx = lowerBound(A[i] + M,A); //처음 위치
            if(idx < N){
                min_diff = Math.min(min_diff, A[idx] - A[i]);
            }
        }
        br.close();
        System.out.println(min_diff);
        //2개의 수를 고르고 차이가 M이상이면서 제일 작은 경우를 구해
    }

    public static int lowerBound(int target, int[] arr){
        int start = 0;
        int end = arr.length;
        while(start < end){
            int mid = (start + end)/2;
            if(arr[mid] >= target){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }



}
