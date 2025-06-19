package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/14442
public class problem_14442 {

    public static int[][] map;
    public static boolean[][][] visited;

    public static int N,M,K;

    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]); // y
        M = Integer.parseInt(line[1]); // x
        K = Integer.parseInt(line[2]);

        fillMap(br);
        System.out.println(BFS());
    }

    public static int BFS(){
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.offerLast(new Node(1,1,0,1));
        visited[1][1][0] = true;


        while(!deque.isEmpty()){
            Node cur = deque.pollFirst();

            if(cur.y == N && cur.x == M){
                return cur.moveCount;
            }

            for(int i = 0; i < 4; i++){
                int nextY = cur.y + dy[i];
                int nextX = cur.x + dx[i];

                if(nextY < 1 || nextX < 1 || nextX > M || nextY > N) continue;

                if(map[nextY][nextX] == 0){
                    //crashCount > 0, 그냥 이동
                    if(!visited[nextY][nextX][cur.crashCount]){
                        visited[nextY][nextX][cur.crashCount] = true;
                        deque.offerLast(new Node(nextY,nextX,cur.crashCount,cur.moveCount + 1));
                    }
                }
                else if(map[nextY][nextX] == 1){
                    if(cur.crashCount < K && !visited[nextY][nextX][cur.crashCount + 1]){
                        visited[nextY][nextX][cur.crashCount + 1] = true;
                        deque.offerLast(new Node(nextY,nextX,cur.crashCount + 1,cur.moveCount + 1));
                    }
                }
            }

        }
        return -1;

    }

    public static class Node{
        int y;
        int x;
        int crashCount;
        int moveCount;
        Node(int y, int x, int crashCount, int moveCount){
            this.y = y;
            this.x = x;
            this.crashCount = crashCount;
            this.moveCount = moveCount;
        }
    }

    public static void fillMap(BufferedReader br) throws IOException {
        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1][K + 1];

        for(int i = 1; i <= N; i++) {
            String[] line = br.readLine().split( "");
            for(int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(line[j - 1]);
            }
        }

    }

}
