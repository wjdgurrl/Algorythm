package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/2206
public class problem_2206 {

    private static int[][] map;
    private static boolean[][] visited;
    private static boolean[][] visited2; //부수고

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        visited2 = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
        System.out.println(BFS());
    }

    private static int BFS(){
        ArrayDeque<Point> deque = new ArrayDeque<>();
        deque.offerLast(new Point(0,0,1, false));
        visited[0][0] = true;

        while(!deque.isEmpty()){
            Point p = deque.pollFirst();

            if(p.y == map.length-1 && p.x == map[0].length-1){
                return p.count;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= map[0].length || nextY >= map.length) continue;


                if(map[nextY][nextX] == 0){
                    //그냥 이동
                    if(!p.crashed && !visited[nextY][nextX]){
                        visited[nextY][nextX] = true;
                        deque.offerLast(new Point(nextX, nextY, p.count + 1, false));
                    }
                    //부셨고 이동
                    else if(p.crashed && !visited2[nextY][nextX]){
                        visited2[nextY][nextX] = true;
                        deque.offerLast(new Point(nextX, nextY, p.count + 1, true));
                    }
                }
                //벽부수고 이동
                else if(map[nextY][nextX] == 1){
                    if(!p.crashed && !visited[nextY][nextX]){
                        visited[nextY][nextX] = true;
                        deque.offerLast(new Point(nextX, nextY, p.count + 1, true));
                    }

                }
            }
        }
        return -1;

    }

    private static class Point {
        int x;
        int y;
        int count;
        boolean crashed;

        Point(int x, int y, int count, boolean crashed) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.crashed = crashed;
        }

    }
}
