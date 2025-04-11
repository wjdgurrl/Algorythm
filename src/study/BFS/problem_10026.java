package study.BFS;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/10026
public class problem_10026 {

    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] graph = new String[N][N];
        String[][] graph2 = new String[N][N];
        boolean[][] visited = new boolean[N][N];
        boolean[][] visited2 = new boolean[N][N];
        int count = 0;
        int count2 = 0;

        //입력받기
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            graph[i] = line;
            String[] line2 = line.clone();
            for (int j = 0; j < line2.length; j++) {
                if(line2[j].equals("G")) {
                    line2[j] = "R";
                }
            }
            graph2[i] = line2;
        }


        //정상
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    BFS(new Node(i,j),visited,N,graph);
                    count++;
                }
                //적녹
                if(!visited2[i][j]) {
                    BFS(new Node(i,j),visited2,N,graph2);
                    count2++;
                }
            }
        }

        System.out.println(count + " " + count2);

    }


    private static void BFS(Node start, boolean[][] visited, int N, String[][] graph){
        ArrayDeque<Node> deque = new ArrayDeque<>();
        visited[start.x][start.y] = true;
        deque.offerLast(start);

        while(!deque.isEmpty()){
            Node current = deque.pollFirst();
            int currentX = current.x;
            int currentY = current.y;
            String currentColor = graph[currentX][currentY];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                if(visited[nextX][nextY]) continue;
                if(!currentColor.equals(graph[nextX][nextY])) continue;


                deque.offerLast(new Node(nextX, nextY));
                visited[nextX][nextY] = true;
            }
        }

    }

    private static class Node{
        int x,y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

