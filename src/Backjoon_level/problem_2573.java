package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/2573
public class problem_2573 {

    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};


    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);


        setMap(N,M,br);
        int time = 0;
        while( true ){
            visited = new boolean[N][M];
            int iceCount = 0;

            //얼음 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        BFS(i, j);
                        iceCount++;
                    }
                }
            }

            if(iceCount >= 2){
                System.out.println(time);
                break;
            }

            //다 지나고 전부 사라지면
            if(iceCount <= 0){
                System.out.println(0);
                break;
            }

            meltIce();
            time++;


        }


    }

    //bfs는 덩어리 탐색용으로
    private static void BFS(int n, int m){

        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.offer(new Node(n,m));
        visited[n][m] = true;

        while(!deque.isEmpty()){
            Node current = deque.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nextN = current.n + dx[i];
                int nextM = current.m + dy[i];

                if(nextM < 0 || nextN < 0 || nextN >= map.length || nextM >= map[0].length) continue;
                if (visited[nextN][nextM] || map[nextN][nextM] < 1) continue;

                visited[nextN][nextM] = true;
                deque.offer(new Node(nextN,nextM));
            }

        }

    }


    private static void meltIce(){

        int[][] meltMap = new int[N][M];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] > 0){
                    int zeroCount = 0; //주위

                    for (int k = 0; k < 4; k++) {
                        int nextN = i + dx[k];
                        int nextM = j + dy[k];
                        if(nextN < 0 || nextM < 0 || nextN >= N || nextM >= M) continue;
                        if(map[nextN][nextM] == 0) zeroCount++;
                    }

                    meltMap[i][j] = (map[i][j] - zeroCount) >= 0 ? map[i][j] - zeroCount : 0;

                }

            }
        }
       /* map = meltMap;*/
        for (int i = 0; i < N; i++) {
            System.arraycopy(meltMap[i], 0, map[i], 0, M);
        }
    }


    private static void setMap(int N , int M, BufferedReader br)throws IOException {
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
    }

    private static class Node{
        int n; // y
        int m; // x

        Node(int n, int m) {
            this.n = n;
            this.m = m;
        }

    }

}
