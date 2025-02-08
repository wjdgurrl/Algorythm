package study.BACKTRACKING;

import java.util.*;
import java.io.*;

public class problem_1182 {

    static int N,S;
    static int[] arr;
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); //정수 개수
        S = Integer.parseInt(input[1]); //다 더한값
        arr = new int[N];
        String[] array = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(array[i]);
        }

        dfs(0,0);

        if(S == 0) count--;

        System.out.println(count);

    }
    //맨 앞부터 들어갈지 말지 결정하기
    public static void dfs(int depth,int sum){
        if(depth == N){
            if(sum == S){
                count++;
            }
            return ;
        }
        dfs(depth+1, sum);//현재꺼 안들어가지
        dfs(depth+1,sum+arr[depth]); //들어가기

    }
}
