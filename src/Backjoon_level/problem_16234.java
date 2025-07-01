package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/16234
public class problem_16234 {

    private static int[][] map;
    private static boolean[][] visited;
    private static int N;
    private static int L;
    private static int R;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        setMap(br);
        //System.out.println(Arrays.deepToString(map));

        int day = 0;

        while(true){
            visited = new boolean[N][N];
            boolean end = true;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j]){
                        if(!bfs(i,j)){ // 하나라도 움직이면 계속 해야 됨
                            end = false;
                        }
                    }
                }
            }
            if(end) break;

            day++;
        }
        System.out.println(day);


    }

    public static boolean bfs(int R, int C){
        ArrayDeque<Node> deque = new ArrayDeque<>();
        ArrayList<Node> list = new ArrayList<>();

        deque.offerLast(new Node(R, C));
        list.add(new Node(R, C)); // 이은 나라

        int unionPeople = map[R][C];
        visited[R][C] = true;

        while(!deque.isEmpty()){
            Node cur = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nextR = cur.r + dy[i];
                int nextC = cur.c + dx[i];

                if(nextR < 0 || nextC < 0 || nextR >= N || nextC >= N) continue;
                if(visited[nextR][nextC]) continue;

                //인구수 비교
                if(peopleCompare(map[cur.r][cur.c], map[nextR][nextC])){
                  deque.offerLast(new Node(nextR, nextC));
                  list.add(new Node(nextR, nextC));
                  visited[nextR][nextC] = true;
                  unionPeople += map[nextR][nextC];
                }
            }

        }

        if(list.size() == 1) return true;

        int balancedPeople = unionPeople / list.size();
        for (Node change : list){
            map[change.r][change.c] = balancedPeople;
        }
        return false;

    }

    public static boolean peopleCompare(int cur, int next){
        int diff = Math.abs(cur - next);

        return L <= diff && diff <= R;
    }

    static class Node{
        int r;
        int c;

        Node(int r,int c){
            this.r=r;
            this.c=c;
        }
    }

    public static void setMap(BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        L = Integer.parseInt(line[1]);
        R = Integer.parseInt(line[2]);
        map = new int[N][N];

        /*if(N > 1){
            map = new int[N + N-1][N + N-1];
            visited = new boolean[N + N - 1][N + N - 1];
        }else {
            map = new int[N][N];
            visited = new boolean[N][N];
        }

        for (int[] temp : map){
            Arrays.fill(temp, -1);
        }*/


        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

    }
}
