package study.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

//https://www.acmicpc.net/problem/7569
public class problem_7569 {

    private static int[][][] graph;
    private static ArrayDeque<Node> deque;
    private static int[] dx = {0,0,-1,1,0,0};
    private static int[] dy = {-1,1,0,0,0,0};
    private static int[] dz = {0,0,0,0,-1,1};

    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]); //가로칸
        int N = Integer.parseInt(input[1]); //세로칸
        int H = Integer.parseInt(input[2]); //높이칸

        graph = new int[H][N][M];
        deque = new ArrayDeque<>();
        count = 0;

        //int[H][N][M]
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                String[] line = br.readLine().split(" ");
                for (int k = 0; k < M; k++) {
                    int tomato = Integer.parseInt(line[k]);
                    if(tomato == 1){
                        deque.offerLast(new Node(k,j,i));
                    }
                    graph[i][j][k] = tomato;
                }
            }
        }
        BFS(M,N,H);

        //체크
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(graph[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }


        System.out.println(count-1);
    }

    private static void BFS(int m,int n,int h){
        while(!deque.isEmpty()){

            int size = deque.size(); // 현재 큐의 노드 수
            count++;

            for(int s = 0; s < size; s++){
                Node current = deque.pollFirst();
                int currentM = current.m;
                int currentN = current.n;
                int currentH = current.h;

                for (int i = 0; i < 6; i++) {
                    int nextM = currentM + dx[i];
                    int nextN = currentN + dy[i];
                    int nextH = currentH + dz[i];

                    if(nextH < 0 || nextH >= h || nextN < 0 || nextN >= n || nextM < 0 || nextM >= m) continue;
                    if(graph[nextH][nextN][nextM] != 0) continue;

                    if(graph[nextH][nextN][nextM] == 0){
                        graph[nextH][nextN][nextM] = 1;
                        deque.offerLast(new Node(nextM,nextN,nextH));
                    }
                }
            }
        }
    }

    private static class Node {
        int m;
        int n;
        int h;

        Node(int m, int n, int h) {
            this.m = m;
            this.n = n;
            this.h = h;
        }
    }
}
