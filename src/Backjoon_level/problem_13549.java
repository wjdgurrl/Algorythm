package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/13549
public class problem_13549 {

    public static int[] dx = {-1,1,2};
    public static HashSet<Integer> visited;
    public static int N;
    public static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        visited = new HashSet<>();
        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);

        bfs(N);
    }

    public static void bfs(int start){
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offerLast(new Node(start,0));

        while(!queue.isEmpty()){
            Node cur = queue.pollFirst();

            //방문처리를 꺼낼때ㅣ
            if(visited.contains(cur.x)) continue;
            visited.add(cur.x);

            //System.out.println("Visited: " + cur.x + " (time: " + cur.count + ")");

            if(cur.x == K){
                System.out.println(cur.count);
                return;
            }

            for (int i = 0; i < 3; i++) {
                int nextX;
                if(i == 2) {
                    nextX = cur.x * 2;
                } else {
                    nextX = cur.x + dx[i];
                }

                if(nextX < 0 || nextX > 200000) continue;


                if(i == 2){
                    queue.offerFirst(new Node(nextX,cur.count)); //0
                }else{
                    queue.offerLast(new Node(nextX , cur.count + 1));
                }

            }
        }

    }

    public static class Node{
        private int x;
        private int count;

        Node(int x, int count){
            this.x = x;
            this.count = count;
        }
    }
}
