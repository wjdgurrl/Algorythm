package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/16933
public class problem_16933 {
    static int N;
    static int M;
    static int K;
    static int[][] map;
    static boolean[][][][] visited;

    static int[] dx = new  int[]{-1, 1, 0, 0};
    static int[] dy = new  int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line =  br.readLine().split(" ");

        //1 based
        N = Integer.parseInt(line[0]); // y
        M = Integer.parseInt(line[1]); // x
        K = Integer.parseInt(line[2]);

        // 0,0 -> n-1,m-1

        fillMap(br);

        int answer = bfs();
        System.out.println(answer);


    }

    public static void fillMap(BufferedReader br) throws IOException{
        map = new int[N][M];
        visited = new boolean[N][M][K+1][2];

        for(int i = 0; i < N ; i++){
            String line = br.readLine();
            for(int j = 0; j < M ; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

    }

    public static int bfs(){
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.offerLast(new Node(0,0,1, 0, true));
        visited[0][0][0][1] = true; //낮 밤 취급

        while(!deque.isEmpty()){
            Node cur = deque.pollFirst();
            int curTime = cur.isMorning ? 1 : 0;

            if(cur.y == N - 1 && cur.x == M - 1){
                return cur.moveCount;
            }

            for(int i = 0; i < 4; i++){
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];


                if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) continue;

                if(map[nextY][nextX] == 0){
                    if(visited[nextY][nextX][cur.crashCount][1 - curTime]) continue;
                    visited[nextY][nextX][cur.crashCount][1 - curTime] =  true;
                    deque.offerLast(new Node(nextY,nextX, cur.moveCount + 1, cur.crashCount, !cur.isMorning));
                }
                else if(map[nextY][nextX] == 1 && cur.crashCount < K && cur.isMorning){
                    //아직 부술 수 있을떄
                    if(visited[nextY][nextX][cur.crashCount + 1][1 - curTime]) continue;
                    visited[nextY][nextX][cur.crashCount + 1][1 - curTime] = true;
                    deque.offerLast(new Node(nextY,nextX, cur.moveCount + 1, cur.crashCount + 1, !cur.isMorning));

                }
            }
            //대기할 때
            if(!visited[cur.y][cur.x][cur.crashCount][1 - curTime]){
                visited[cur.y][cur.x][cur.crashCount][1 - curTime] =  true;
                deque.offerLast(new Node(cur.y, cur.x, cur.moveCount + 1, cur.crashCount, !cur.isMorning));
            }


        }

        return -1;

    }

    public static class Node{
        int y;
        int x;
        int moveCount;
        int crashCount;
        boolean isMorning;

        public Node(int y, int x, int moveCount,int crashCount, boolean isMorning){
            this.y = y;
            this.x = x;
            this.moveCount = moveCount;
            this.crashCount = crashCount;
            this.isMorning = isMorning;
        }
    }

}
