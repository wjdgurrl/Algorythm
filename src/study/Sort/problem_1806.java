package study.Sort;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/1806
public class problem_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE; //수열 길이
        int total = 0;// 길이만큼 합

        //[5][2][3][4][1]
        while(true){
            //total 이 S이상이면 start를 한칸 이동
            if(total >= S){
                min = Math.min(min, end - start);
                total -= arr[start++];
            }
            else if(end == N){
                //end 끝에 도달 시 종료
                break;
            }else{
                //부분합이 s보다 작으면 end 이동
                total += arr[end++];
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? 0 : min );

    }
}
