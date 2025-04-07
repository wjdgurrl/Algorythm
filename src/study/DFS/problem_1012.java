package study.DFS;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/1012

//bfs 풀이
/*public class problem_1012 {
    private static int[][] graph;
    private static boolean[][] visited;
    private static ArrayDeque<Node> deque;

    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        //그래프 채우기
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int m = Integer.parseInt(input[0]); // 가로
            int n = Integer.parseInt(input[1]); // 세로
            int k = Integer.parseInt(input[2]); // 배추 개수

            graph = new int[n][m];
            visited = new boolean[n][m];
            deque = new ArrayDeque<>();
            int count = 0;

            for(int j = 0; j < k; j++) {
                String[] spot = br.readLine().split(" ");
                int b = Integer.parseInt(spot[0]); // x
                int a = Integer.parseInt(spot[1]); // y
                graph[a][b] = 1;
            }

            for(int j = 0; j < n; j++) {
                for(int l = 0; l < m; l++) {
                    if(graph[j][l] == 1 && !visited[j][l]) {
                        BFS(l,j,m,n);
                        count++;
                    }
                }
            }

            System.out.println(count);

        };
    }

    private static int BFS(int startX, int startY, int xlen, int ylen) {
        deque.offerLast(new Node(startX, startY));
        visited[startY][startX] = true;

        while(!deque.isEmpty()){
            Node current = deque.pollFirst();
            int x = current.x;
            int y = current.y;
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX < 0 || nextX >= xlen || nextY < 0 || nextY >= ylen ) continue;
                if(visited[nextY][nextX]) continue;
                if(graph[nextY][nextX] == 0) continue;

                visited[nextY][nextX] = true;
                deque.offerLast(new Node(nextX, nextY));
            }
        }
        return 1;
    }

    private static class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
}*/

//dfs 풀이
public class problem_1012 {

    private static int[][] graph;
    private static boolean[][] visited;
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        //그래프 채우기
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int m = Integer.parseInt(input[0]); // 가로
            int n = Integer.parseInt(input[1]); // 세로
            int k = Integer.parseInt(input[2]); // 배추 개수
            int count = 0;

            graph = new int[n][m];
            visited = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                String[] spot = br.readLine().split(" ");
                int x = Integer.parseInt(spot[0]);
                int y = Integer.parseInt(spot[1]);
                graph[y][x] = 1;
            }

            for(int j = 0; j < m; j++) { //y
                for(int l = 0; l < n; l++) { //x
                    if(graph[l][j] == 1 && !visited[l][j]) {
                        dfs(j,l,m,n);
                        count++;
                    }
                }
            }
            System.out.println(count);

        }
    }

    private static void dfs(int x, int y, int xlen, int ylen) {
        visited[y][x] = true;

        for (int k = 0; k < 4; k++) {
            int nextX = x + dx[k];
            int nextY = y + dy[k];

            if(nextX < 0 || nextY < 0 || nextX >= xlen || nextY >= ylen) continue;
            if(visited[nextY][nextX]) continue;
            if(graph[nextY][nextX] == 0) continue;

            dfs(nextX, nextY, xlen, ylen);
        }
    }
}
