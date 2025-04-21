package study.BFS;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/2583
public class problem_2583 {
    private static boolean[][] map;
    private static boolean[][] visited;

    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};

    private static ArrayDeque<Node> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int M = Integer.parseInt(line[0]); //가로
        int N = Integer.parseInt(line[1]); //세로
        map = new boolean[M][N];
        visited = new boolean[M][N];
        deque = new ArrayDeque<>();
        int K = Integer.parseInt(line[2]); //직사각형 (왼쪽아래 , 우측 상단)

        ArrayList<Integer> sizes = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            String[] dots = br.readLine().split(" ");
            int ax = Integer.parseInt(dots[0]); // 확대 전 a.x
            int ay = Integer.parseInt(dots[1]); // 확대 전 a.y
            int bx = Integer.parseInt(dots[2]); // 확대 전 b.x
            int by = Integer.parseInt(dots[3]); // 확대 전 b.y

            drawSquare(ax, ay, bx, by);
        }
        int count = 0;

        //시작점 넣기
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!map[i][j] && !visited[i][j]) {
                    sizes.add(BFS(j,i));
                    count ++;
                }
            }
        }

        Collections.sort(sizes);
        StringBuilder sb = new StringBuilder();
        System.out.println(count);
        for(int s : sizes) {
            sb.append(s).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static int BFS(int x, int y){
        int size = 0;
        deque.offerLast(new Node(x,y));
        visited[y][x] = true;

        while(!deque.isEmpty()){
            Node current = deque.pollFirst();
            size ++;

            for(int i = 0; i < 4; i++){
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= map[0].length|| nextY >= map.length){
                    continue;
                }
                if(visited[nextY][nextX] || map[nextY][nextX]){
                    continue;
                }

                visited[nextY][nextX] = true;
                deque.offerLast(new Node(nextX,nextY));
            }
        }
        return size;
    }


    private static void drawSquare(int ax, int ay, int bx, int by) {

        for(int i = ay; i < by; i++){
            for (int j = ax; j < bx ; j++){
                map[i][j] = true;
            }
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
}
