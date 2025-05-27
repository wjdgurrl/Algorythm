package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/9466
public class problem_9466 {
    private static int count;
    private static boolean[] visited;
    private static boolean[] finished;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            count = 0;
            visited = new boolean[n+1];
            finished = new boolean[n+1];
            arr = new int[n+1];

            String[] student_picks = br.readLine().split(" ");
            for(int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(student_picks[j-1]);
            }
            for (int j = 1; j <= n; j++) {
                if(!visited[j]) dfs(j);
            }
            System.out.println(n - count);
        }
    }

    private static void dfs(int node) {
        visited[node] = true;
        int next = arr[node];

        if(!visited[next]) dfs(next);
        else if(!finished[next]){
            count++;

            //원 완성
            for(int temp = next; temp != node; temp = arr[temp]){
                count++;
            }
        }

        finished[node] = true;
    }

}
