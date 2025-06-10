package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/1600
public class problem_1600 {
    private static int W;
    private static int H;
    private static int[][] map;
    private static boolean[][][] visited; // K 따라

    private static int[] dx = {0, -1, 0, 1,  -2, -2, -1, -1, 1, 1, 2, 2}; // 좌상단 좌하단 우상단 우하단
    private static int[] dy = {-1, 0, 1, 0,  -1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        W = Integer.parseInt(line[0]);
        H = Integer.parseInt(line[1]);
        map = new int[H][W];
        fillMap(br);
        int count = bfs(K);
        System.out.println(count);
    }

    public static int bfs(int K){
        visited = new boolean[H][W][K+1];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offerLast(new Node(0,0,K,0));
        visited[0][0][K] = true;

        while(!queue.isEmpty()){
            Node cur = queue.pollFirst();

            if(cur.y == H - 1 && cur.x == W - 1){
                return cur.count;
            }

            int t = 4;
            if(cur.K > 0) t = 12;

            for (int i = 0; i < t; i++) {
                int nextY = cur.y + dy[i];
                int nextX = cur.x + dx[i];

                if(nextX < 0 || nextY < 0 || nextX >= W || nextY >= H) continue;
                if(map[nextY][nextX] == 1) continue;

                //K차감
                if(i >= 4) {
                    if(!visited[nextY][nextX][cur.K - 1]) {
                        visited[nextY][nextX][cur.K - 1] = true;
                        queue.offerLast(new Node(nextY, nextX, cur.K - 1, cur.count + 1));
                    }
                } else {
                    if(!visited[nextY][nextX][cur.K]) {
                        visited[nextY][nextX][cur.K] = true;
                        queue.offerLast(new Node(nextY, nextX, cur.K, cur.count + 1));
                    }
                }

            }
        }
        return -1;
    }


    public static void fillMap(BufferedReader br) throws IOException {
        for (int i = 0; i < H; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
    }

    public static class Node{
        int y;
        int x;
        int K;
        int count;

        Node(int y, int x, int K, int count){
            this.y = y;
            this.x = x;
            this.K = K;
            this.count = count;
        }
    }
}
