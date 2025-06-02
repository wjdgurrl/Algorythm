package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/14889
public class problem_14889 {
    private static int[][] stats;
    private static boolean[] visited;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());
        stats = new int[N][N];
        visited = new boolean[N];
        mapStats(br);
        dfs(0,0);

        System.out.println(min);
    }

    public static void dfs(int depth, int start) {
        if(depth == stats.length / 2){

            int team1 = 0;
            int team2 = 0;

            for (int i = 0; i < stats.length; i++) {
                for(int j = 0; j < stats[0].length; j++){
                    if(visited[i] && visited[j]) team1 += stats[i][j];
                    if(!visited[i] && !visited[j]) team2 += stats[i][j];
                }
            }

            min = Math.min(min, Math.abs(team1 - team2));
        }

        //어짜피 i,j j,i니까 이전꺼 인덱스 탐색 안해도 됨
        for (int i = start; i < stats.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }

    }

    public static void mapStats(BufferedReader br) throws IOException {
        for (int i = 0; i < stats.length; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < stats[i].length; j++) {
                stats[i][j] = Integer.parseInt(line[j]);
            }
        }
    }
}
