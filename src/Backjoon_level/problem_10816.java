package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/10816
public class problem_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();

        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            int count = upperIndex(num,arr) - lowerIndex(num,arr);
            sb.append(count).append(" ");
        }
        System.out.print(sb.toString().trim());

    }
    //target 이상의 값이 처음 등장하는 위치
    public static int lowerIndex(int target, int[] arr){
        int start = 0;
        int end = arr.length;
        while(start < end){
            int mid = (start + end) / 2;
            if(arr[mid] >= target) {
                end = mid; //타겟이 end보다 오른쪽에 있음
            }else{
                start = mid + 1;
            }
        }
        return start;
    }

    //target 초과하는 값이 처음 등장하는 위치
    public static int upperIndex(int target, int[] arr){
        int start = 0;
        int end = arr.length;
        while(start < end){
            int mid = (start + end) / 2;
            if(arr[mid] > target) {
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
}
