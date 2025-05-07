package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/11559
public class problem_11559 {

    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};

    private static String[][] map;
    private static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        map = fillMap(br);

        while (true) {
            boolean isBoom = false;
            visited = new boolean[12][6];

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if(!map[i][j].equals(".") && !visited[i][j]) {
                        if(BFS(j,i)){
                            isBoom = true;
                        }
                    }
                }
            }

            if(!isBoom) {
                break;
            }
            moveDown();
            answer++;
        }

        System.out.println(answer);

    }

    private static void moveDown(){
        for (int i = 0; i < 6; i++) { // x 무빙
            int count = 0;
            for (int j = 11; j >= 0; j--) { //y무빙
                if(map[j][i].equals(".")){
                    count++;
                    continue;
                }
                if(count > 0){
                    map[j+count][i] = map[j][i];
                    map[j][i] = ".";
                }
            }
        }
    }

    private static boolean BFS(int startX, int startY){ //폭발여부 출력
        ArrayDeque<Node> deque = new ArrayDeque<Node>();
        ArrayList<Node> deleteList = new ArrayList<Node>();

        String curColor = map[startY][startX];
        Node start = new Node(startX,startY,curColor);
        visited[startY][startX] = true;
        deque.offerLast(start);
        deleteList.add(start); //일단 자기도 대상이 될 수 있으니

        while(!deque.isEmpty()){
            Node current = deque.pollFirst();
            curColor = current.color;
            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if(nextY < 0 || nextX <0 || nextY >= 12 || nextX >= 6) continue;
                if(visited[nextY][nextX] || !map[nextY][nextX].equals(curColor)) continue;

                visited[nextY][nextX] = true;
                Node target = new Node(nextX,nextY,curColor);
                deque.offerLast(target);
                deleteList.add(target);
            }
        }

        if(deleteList.size() >= 4){
            for(Node target : deleteList){
                map[target.y][target.x] = ".";
            }
            return true;
        }
        deleteList.clear();
        return false;
    }

    private static String[][] fillMap(BufferedReader br) throws IOException {
        String[][] map = new String[12][6];
        for (int i = 0; i < 12; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < 6; j++) {
                map[i][j] = line[j];
            }
        }
        return map;
    }

    private static class Node{
        private int x, y;
        private String color;

        private Node(int x, int y, String color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

}
