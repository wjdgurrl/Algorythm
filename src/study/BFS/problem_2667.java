package study.BFS;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/2667
public class problem_2667 {

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        int[][] map = drawMap(br,N);

        ArrayList<Integer> sizes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((map[i][j] == 1) && !visited[i][j]) {
                    sizes.add(BFS(j,i,N,map));
                }
            }
        }
        Collections.sort(sizes);
        System.out.println(sizes.size());
        for (Integer size : sizes) {
            System.out.println(size);
        }

    }

    private static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static int BFS(int x, int y, int N,int[][] map){
        ArrayDeque<Node> deque = new ArrayDeque<>();
        int count = 0;
        deque.offerLast(new Node(x, y));
        visited[y][x] = true;

        while(!deque.isEmpty()){
            Node current = deque.pollFirst();
            count++;

            for(int i = 0; i < 4; i++){
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                if(visited[nextY][nextX] || map[nextY][nextX] == 0) continue;

                visited[nextY][nextX] = true;
                deque.offerLast(new Node(nextX, nextY));
            }
        }
        return count;
    }

    private static int[][] drawMap(BufferedReader br,int N) throws IOException {
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
        return map;
    }
}
