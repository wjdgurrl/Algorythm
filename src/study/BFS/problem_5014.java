package study.BFS;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/5014
public class problem_5014 {

    private static boolean[] building; //가면 true;
    private static ArrayDeque<Node> deque;
    private static int[] moves;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int F = Integer.parseInt(line[0]); // 총 층 개수
        int S = Integer.parseInt(line[1]); // 강호 현재 층
        int G = Integer.parseInt(line[2]); // 사무실 층
        int U = Integer.parseInt(line[3]); // 위로 u만큼 올라가는 버튼
        int D = Integer.parseInt(line[4]); // 아래로 d만큼 내려가는 버튼

        moves = new int[]{U,-D};
        building = new boolean[F+1];
        int answer = BFS(S,G);
        System.out.println(answer == -1 ? "use the stairs" : answer);

    }

    private static int BFS(int S, int G){
        deque = new ArrayDeque<>();

        building[S] = true;
        deque.offerLast(new Node(S,0));

        while(!deque.isEmpty()){
            Node current = deque.pollFirst();

            if(current.floor == G){
                //도달
                return current.count;
            }

            for (int move : moves){
                if(move == 0) continue;
                int nextFloor = current.floor + move;
                if(nextFloor <= 0 || nextFloor >= building.length) continue;
                if(building[nextFloor]) continue;

                building[nextFloor] = true;
                deque.offerLast(new Node(nextFloor, current.count + 1));
            }
        }

        return -1;
    }

    private static class Node{
        private int floor;
        private int count;

        private Node(int floor, int count){
            this.floor = floor;
            this.count = count;
        }
    }
    /*
    u - 2 d - 1
    [10] g
    [9]
    [8]
    [7]
    [6]
    [5]
    [4]
    [3]
    [2]
    [1] s
    [0] //구색
    */
}
