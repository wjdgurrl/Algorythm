package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/14002
public class problem_14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>(); // dp[i]는 i번째 수를 마지막으로 하는 수열
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> maxList = new ArrayList<>(); // 최대수열
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp.get(j).size() > maxList.size()) {
                    maxList = dp.get(j);
                }
            }
            ArrayList<Integer> temp = new ArrayList<>(maxList);
            temp.add(arr[i]); //
            dp.add(temp);
        }

        //수열 검색
        ArrayList<Integer> maxList = new ArrayList<>();
        for (int i = 0; i < dp.size(); i++) {
            if(dp.get(i).size() > maxList.size()){
                maxList = dp.get(i);
            }
        }

        System.out.println(maxList.size());
        for (int i = 0; i < maxList.size(); i++) {
            System.out.print(maxList.get(i) + " ");
        }



    }
}
