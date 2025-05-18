package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/14503
public class problem_14503 {

    private static int[][] room; //0이면 청소할 곳, 1이면 벽, -1이면 청소완료
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};
    private static boolean[][] visited;
    private static int count = 0;
    //북동남서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");// n,m
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        room = new int[N][M];
        visited = new boolean[N][M];
        input = br.readLine().split(" "); // r,c,d
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        int d = Integer.parseInt(input[2]); //0북,1동,2남,3서
        fillRoom(br);

        bfs(r, c, d);
        System.out.println(count);

    }

    private static void bfs(int r, int c, int d){
        ArrayDeque<Robot> deque = new ArrayDeque<>();
        deque.offerLast(new Robot(r, c, d));

        while(!deque.isEmpty()){
            Robot current = deque.pollFirst();

            if(!visited[current.r][current.c]){
                visited[current.r][current.c] = true;
                count++;
            }

            boolean moved = false; //4칸 존재 검사

            for (int i = 0; i < 4; i++) {
                d = (d+3) % 4; //회전
                int nextR = current.r + dy[d];
                int nextC = current.c + dx[d];

                if(nextR < 0 || nextC < 0 || nextR >= room.length || nextC >= room[0].length) continue;
                if(visited[nextR][nextC] || room[nextR][nextC] == 1) continue;

                //청소할 구역 있음
                deque.offerLast(new Robot(nextR, nextC, d));
                moved = true;
                break;

            }
            //구역 없음
            if(!moved){
                //후진
                int backD = (d + 2) % 4;
                int backR = current.r + dy[backD];
                int backC = current.c + dx[backD];
                if(backR < 0 || backC < 0 || backR >= room.length || backC >= room[0].length || room[backR][backC] == 1) return;
                else{
                    deque.offerLast(new Robot(backR, backC, d)); //방향은 유지해서 후진
                }
            }
        }
    }


    private static class Robot{
        int r;
        int c;
        int direction;

        private Robot(int r, int c, int direction) {
            this.r = r;
            this.c = c;
            this.direction = direction;
        }
    }

    private static void fillRoom(BufferedReader br)throws IOException {
        for (int i = 0; i < room.length; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < room[i].length; j++) {
                room[i][j] = Integer.parseInt(input[j]);
            }
        }
    }


}
