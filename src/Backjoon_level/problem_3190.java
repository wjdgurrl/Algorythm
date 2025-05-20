package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/3190
public class problem_3190 {

    private static int[][] board; // 2뱀
    private static ArrayDeque<Move> moves;

    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};
    //동남서북

    private static int totalTime = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //보드 크기
        board = new int[N][N];
        int K = Integer.parseInt(br.readLine()); // 사과 개수
        for (int i = 0; i < K; i++) {
            String[] line = br.readLine().split(" ");
            board[Integer.parseInt(line[0]) - 1][Integer.parseInt(line[1]) - 1]  =  1;
        }
        moves = new ArrayDeque<>();
        int L = Integer.parseInt(br.readLine()); // 방향
        for (int i = 0; i < L; i++) {
            String[] line = br.readLine().split(" ");
            moves.offerLast(new Move(Integer.parseInt(line[0]),line[1]));
        }
        move();
        System.out.println(totalTime);
    }

    public static void move(){
        ArrayDeque<Snake> snake = new ArrayDeque<>();
        board[0][0] = 2;
        snake.offerLast(new Snake(0,0));
        int direction = 0; //뱀 전체 움직임


        while(true){
            totalTime++;

            Snake head = snake.peekFirst(); // peek으로 확인
            int nextX = head.X + dx[direction];
            int nextY = head.Y + dy[direction];

            if (nextX < 0 || nextY < 0 || nextX >= board.length || nextY >= board.length || board[nextY][nextX] == 2) break;

            //전진

            //사과먹기
            if (board[nextY][nextX] == 1) {
                snake.offerFirst(new Snake(nextX, nextY));
                board[nextY][nextX] = 2;
            } else { //머리 옮기고 꼬리 지우기
                snake.offerFirst(new Snake(nextX, nextY));
                board[nextY][nextX] = 2; //꼬리
                Snake tail = snake.pollLast();
                board[tail.Y][tail.X] = 0;
            }


            //회전
            if (!moves.isEmpty() && moves.peekFirst().x == totalTime) {
                String dir = moves.pollFirst().c;
                if (dir.equals("L")) {
                    direction = (direction + 3) % 4;
                } else if (dir.equals("D")) {
                    direction = (direction + 1) % 4;
                }
            }

        }
    }

    private static class Snake{
        int X;
        int Y;


        private Snake(int X, int Y){
            this.X = X;
            this.Y = Y;
        }
    }

    private static class Move{
        int x;
        String c;

        private Move(int x, String c){
            this.x = x;
            this.c = c;
        }

    }
}
