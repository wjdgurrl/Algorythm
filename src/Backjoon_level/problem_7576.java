package Backjoon_level;

import java.util.*;
import java.io.*;

public class problem_7576 {

    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static int[][] board;
    public static int[][] boxState;
    public static ArrayDeque<Node> queue;


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        board = new int[M][N];
        boxState = new int[M][N];
        queue = new ArrayDeque<>();
        int day = 0;

        //1은 익은 토마토 , 0은 안익은거, -1은 빈 상태
        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(line[j]);
                //모든 시작점을 큐에 넣고 시작해버리자
                if(board[i][j] == 1){
                    boxState[i][j] = 1;
                    queue.offerLast(new Node(i,j)); // 익은 토마토
                }else if(board[i][j] == 0){
                    boxState[i][j] = 0; // 안익은 토마토
                }
                else{
                    boxState[i][j] = -1; // 빈박스
                }
            }
        }

        while(!queue.isEmpty()){
            Node node = queue.pollFirst(); // 큐에서 노드 하나 꺼내기
            int curX = node.x;
            int curY = node.y;

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                //방문 , 범위체크
                if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N){
                    continue;
                }
                if(boxState[nextX][nextY] != 0){ // 안익은 토마토 좌표일 경우
                    continue;
                }

                boxState[nextX][nextY] = boxState[curX][curY] + 1;
                queue.offerLast(new Node(nextX,nextY));
            }

        }

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(boxState[i][j] == 0){ // 안익은 토마토가 남았을 경우
                    day = -1;
                    System.out.println(day);
                    return;
                }
                day = Math.max(day,boxState[i][j]);
            }
        }
        System.out.println(day -1);
        //System.out.println(Arrays.deepToString(boxState));
    }

    public static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
