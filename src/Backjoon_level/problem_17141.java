package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/17141
public class problem_17141 {
    public static int[][] map;
    public static int N;
    public static int M;
    public static ArrayList<Node> virusList = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int minTime = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); //바이러스 개수
        setMap(br,N);



        //dfs로 시작점 찾기
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==2){
                    virusList.add(new Node(i,j)); //시작지점 전부 담기
                }
            }
        }

        if(virusList.isEmpty()){
            System.out.println(0);
            return;
        }

        dfs(0,0,new ArrayList<>());


        System.out.println(minTime == Integer.MAX_VALUE? -1 : minTime);

    }

    public static void dfs(int depth, int index, ArrayList<Node> selectedList){
        if(depth == M){
            bfs(selectedList);
            return;
        }

        for(int i= index; i < virusList.size();i++){
            selectedList.add(virusList.get(i));
            dfs(depth+1,i + 1, selectedList);
            selectedList.remove(selectedList.size()-1);
        }
    }


    public static void bfs(ArrayList<Node> selectedList){
        ArrayDeque<Node> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        int[][] infected = new int[N][N];
        for(int i=0;i<N;i++){
            Arrays.fill(infected[i],-1);
        }
        int maxTime = 0;

        for(Node node:selectedList){
            deque.offerLast(node);
            visited[node.y][node.x] = true;
            infected[node.y][node.x] = 0; //바이러스 시작 위치
        }

        while(!deque.isEmpty()){
            Node node = deque.pollFirst();
            infected[node.y][node.x] = node.time;

            for(int i=0;i<4;i++){
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];

                if(nextY < 0 || nextY >= N || nextX < 0 || nextX >= N) continue;
                if(visited[nextY][nextX]) continue;
                if(map[nextY][nextX] == 1) continue;

                visited[nextY][nextX] = true;
                deque.offerLast(new Node(nextY,nextX,node.time + 1));

            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 1) {
                    maxTime = Math.max(maxTime, infected[i][j]);
                }
            }
        }


        if(checkMap(visited)){
            minTime = Math.min(maxTime,minTime);
        }

    }

    public static boolean checkMap(boolean[][] visited){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                //0인데 방문 안한곳 있음
                if((map[i][j] == 0 || map[i][j] == 2) && !visited[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public static class Node{
        int y;
        int x;
        int time;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
            this.time = 0;
        }

        public Node(int y, int x, int time){
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

    public static void setMap(BufferedReader br,int N)throws IOException{
        map = new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
