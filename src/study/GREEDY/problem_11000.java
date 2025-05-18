package study.GREEDY;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/11000
public class problem_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] starts = new int[N];
        int[] ends = new int[N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            starts[i] = Integer.parseInt(input[0]);
            ends[i] = Integer.parseInt(input[1]);
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int count = 0;
        int max = 0; // 최대 강의실 수
        int i = 0; //s
        int j = 0; //t

        while(i < N && j < N) {
            //새로운 수업이 기존 수업 종료보다 일찍 시작, 강의실 추가
            if(starts[i] < ends[j]){
                count++;
                max = Math.max(max,count);
                i++;
            }else{
                count--;
                j++;
            }
        }

        System.out.println(max);

    }

}
