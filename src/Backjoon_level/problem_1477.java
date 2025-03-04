package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/1477
public class problem_1477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 휴게소 개수
        int M = Integer.parseInt(input[1]); // 더 지으려는 휴게소 수
        int L = Integer.parseInt(input[2]); // 고속도로의 길이
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] stations = new int[N];
        if(N!=0){
            for (int i = 0; i < N; i++) {
                stations[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(stations);
            System.out.println(Arrays.toString(stations));
            int[] diff = new int[N-1];
            int diff_index = 0;
            for (int i = 0; i < N-1; i++) {
                diff[i] = stations[i+1] - stations[i];
                diff_index = Math.max(diff_index,diff[i]);
            }
            System.out.println(Arrays.toString(diff));
            System.out.println(diff_index);
            //각 휴게소마다 길이 구하기?


        }else{//N이 0일 경우
            answer = L/2;
        }
        //다솜이는 이 고속도로를 이용할 때, 모든 휴게소를 방문한다.
        //다솜이는 휴게소를 M개 더 지어서 휴게소가 없는 구간의 길이의 최댓값을 최소로 하려고 한다. (반드시 M개를 모두 지어야 한다.)
    }
}
