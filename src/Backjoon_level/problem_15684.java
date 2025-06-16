package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/15684
public class problem_15684 {
    public static int[][] map;
    public static int N;
    public static int M;
    public static int H;
    public static boolean[][] visited;

    public static int[] dx = {1,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]); //세로 x축
        M = Integer.parseInt(line[1]); // 가로 y축
        H = Integer.parseInt(line[2]); // 사다리
        fillMap(br);
        System.out.println(Arrays.deepToString(map));
        findLadder();
    }

    //추가 해야 하는 가로선 개수의 최소
    public static void findLadder(){
        ArrayDeque<Node> stack = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) {
            int startNum = i;
            System.out.println("startNum = " + startNum);
            stack.offerLast(new Node(1,i));
            visited[startNum][i] = true;

            while(!stack.isEmpty()){
                Node curNode = stack.pop();
                if(curNode.y == M + 2 + H) break;
                System.out.println("curY = " + curNode.y + " curX = " + curNode.x);
                //좌우 탐색
                for (int j = 0; j < 3; j++) {
                    int nextX = curNode.x + dx[j];

                    if(nextX < 1 || nextX >= N + 2 || curNode.y > M) continue;
                    if(visited[curNode.y][nextX]) continue;
                    if(map[curNode.y][nextX] == -1){
                        visited[curNode.y][nextX] = true;
                        stack.offerLast(new Node(curNode.y, nextX));
                        break;
                    }
                    visited[curNode.y + 1][nextX] = true;
                    stack.offerLast(new Node(curNode.y + 1, curNode.x));
                }
            }


        }
    }

    public static class Node{
        int y;
        int x;
        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }


    public static void fillMap(BufferedReader br) throws IOException {
        map = new int[M + 2 + H][N + 2];
        visited = new boolean[M + 2 + H][N + 2];
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = i;
            map[map.length - 1][i] = i;
        }

        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            map[a][b] = -1;
            map[a][b + 1] = -1;
        }
    }
}
