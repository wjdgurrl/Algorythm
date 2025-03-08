package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/1978
public class problem_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer += isPrime(Integer.parseInt(input[i]));
        }

        System.out.println(answer);

    }

    public static int isPrime(int N){
        if(N==1){
            return 0;
        }else{
            for (int i = 2; i*i <= N; i++) {
                if(N % i == 0){
                    return 0;
                }
            }
            return 1;
        }
    }
}
