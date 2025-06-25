package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/17281
public class problem_17281 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //완전탐색

        for (int i = 0; i < N; i++) {
            int outCount = 0;
            HashMap<Integer,Integer> outputs = readOutputs(br); // 선수들 역량
            ArrayList<Integer> list = new ArrayList<>(); //타순
            ArrayDeque<Integer> filed = new ArrayDeque<>(4); //출루


            while (outCount < 3){

            }

        }

    }
    public static HashMap<Integer,Integer> readOutputs(BufferedReader br) throws IOException {
        HashMap<Integer,Integer> outputs = new HashMap<>();
        int num = 0;
        String[] line = br.readLine().split(" ");
        for (String s : line) {
            outputs.put(num++, Integer.parseInt(s));
        }
        return outputs;

    }
}
