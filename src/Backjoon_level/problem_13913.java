package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/13913
public class problem_13913 {
    private static final int len = 100001;
    private static int N;
    private static int K;

    private static int[] dx = {-1,1,2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);
        BFS(N);

    }

    private static void BFS(int N){
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Node> queue = new ArrayDeque<>();
        int[] visited = new int[len];
        int[] history = new int[len];

        queue.offerLast(new Node(N,0));
        visited[N] = 1;
        history[N] = -1; // 전에꺼 기록 배열

        while(!queue.isEmpty()){
            Node cur = queue.pollFirst();

            if(cur.x == K){
                System.out.println(cur.count);
                ArrayList<Integer> historys = new ArrayList<>();
                for (int start = K; start != N ; start = history[start]) {
                    historys.add(start);
                }

                sb.append(N).append(" ");

                for (int i = historys.size()-1 ; i >= 0; i--) {
                    sb.append(historys.get(i)).append(" ");
                }

                System.out.println(sb.toString().trim());
                return;
            }

            for (int i = 0; i < 3; i++) {
                int nextX;
                if(i == 2) nextX = cur.x * 2;
                else nextX = cur.x + dx[i];

                if(nextX < 0 || nextX >= len) continue;
                if(visited[nextX] > 0) continue;


                visited[nextX] = cur.count + 1;
                history[nextX] = cur.x;
                queue.offerLast(new Node(nextX,cur.count + 1));
            }
        }
    }

    private static class Node{
        private int x;
        private int count;

        Node(int x, int count){
            this.x = x;
            this.count = count;
        }
    }
}
