package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/16234
public class problem_16234 {

    private static int[][] map;
    private static boolean[][] visited;
    private static int N;
    private static int L;
    private static int R;

    private static int[] dx = {-2, 2, 0, 0};
    private static int[] dy = {0, 0, -2, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        setMap(br);
        System.out.println(Arrays.deepToString(map));
        //n = 1일때 예외처리 해주가

    }

    public static void bfs(int R, int C){
        ArrayDeque<Node> deque = new ArrayDeque<>();

        visited[R][C] = true;

        while(!deque.isEmpty()){
            Node cur = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nextR = cur.r + dy[i];
                int nextC = cur.c + dx[i];

                if(nextR < 0 || nextC < 0 || nextR >= N || nextC >= N) continue;
                if(map[nextR][nextC] == -1) continue; //국경선
                if(visited[nextR][nextC]) continue;

                visited[nextR][nextC] = true;

                //인구수 비교
                if(peopleCompare(map[cur.r][cur.c], map[nextR][nextC])){
                   //국경 열기


                }



            }

        }

    }

    public static boolean peopleCompare(int cur, int next){
        int diff = Math.abs(cur - next);

        return L <= diff && diff <= R;
    }

    static class Node{
        int r;
        int c;

        Node(int r,int c){
            this.r=r;
            this.c=c;
        }
    }

    public static void setMap(BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        L = Integer.parseInt(line[1]);
        R = Integer.parseInt(line[2]);
        map = new int[N][N];

        /*if(N > 1){
            map = new int[N + N-1][N + N-1];
            visited = new boolean[N + N - 1][N + N - 1];
        }else {
            map = new int[N][N];
            visited = new boolean[N][N];
        }

        for (int[] temp : map){
            Arrays.fill(temp, -1);
        }*/


        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

    }
}
