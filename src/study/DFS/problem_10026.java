package study.DFS;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/10026
public class problem_10026 {

    private static String[][] graph;
    private static boolean[][] visited;

    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new String[N][N];
        //입력받기
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            graph[i] = line;
        }
    }
    public class BFS{


        private static class Node{
            int x;
            int y;
            Node(int x, int y){
                this.x = x;
                this.y = y;
            }
        }
    }
}

