package study.Sort;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/2295
public class problem_2295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> two = new ArrayList<>(); // 두 수의 합
        int N = Integer.parseInt(br.readLine());
        int[] U = new int[N];

        for (int i = 0; i < N; i++) {
            U[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Arrays.sort(U);

        //1. 두 수의, 합을 저장
        for (int i = 0; i < U.length; i++) {
            for (int j = i; j < U.length; j++) {
                two.add(U[i] + U[j]);
            }
        }
        Collections.sort(two);

         int max = 0; //만들 수 있는 최댓값

        //2. X = Y+Z+W 탐색

        for(int k = U.length-1 ; k >= 0;k--){ //가장 큰 X부터 탐색
            for(int m = 0;m < U.length;m++){ // W선택
                int target = U[k] - U[m]; // X-W를 만들 수 있나
                if(Collections.binarySearch(two, target) >= 0){
                    max = Math.max(max, U[k]);
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(max+"");
        bw.close();


    }
}
