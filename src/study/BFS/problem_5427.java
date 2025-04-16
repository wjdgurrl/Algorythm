package study.BFS;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/5427
public class problem_5427 {

    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};

    private static ArrayDeque<Node> manDeque;
    private static ArrayDeque<Node> fireDeque;

    private static boolean[][] visited;
    private static boolean[][] fireVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCases; i++) {
            manDeque = new ArrayDeque<>();
            fireDeque = new ArrayDeque<>();

            String[] input = br.readLine().split(" ");
            int w = Integer.parseInt(input[0]);
            int h = Integer.parseInt(input[1]);

            visited = new boolean[h][w];
            fireVisited = new boolean[h][w];

            String[][] map = drawMap(br,w, h);

            int result = BFS(map);
            System.out.println(result==-1 ? "IMPOSSIBLE" : result);
        }

    }
    //map[h][w]
    /*'.': 빈 공간
    '#': 벽
    '@': 상근이의 시작 위치
    '*': 불*/

    private static String[][] drawMap(BufferedReader br, int w, int h) throws IOException {
        String[][] map = new String[h][w];
        for (int i = 0; i < h; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < w; j++) {
                map[i][j] = line[j];

                if(line[j].equals("@")){
                    manDeque.offerLast(new Node(j, i));
                    visited[i][j] = true;
                }else if(line[j].equals("*")){
                    fireDeque.offerLast(new Node(j, i));
                    fireVisited[i][j] = true;
                }
            }
        }
        return map;
    }

    //불부터 움직이기
    private static int BFS(String[][] map){

        //1턴에 모두 움직이기
        while(!manDeque.isEmpty()){

            //1턴에 불만 움직이기
            int fireSize = fireDeque.size();
            for(int j = 0; j < fireSize; j++){
                Node fireCurrent = fireDeque.pollFirst();
                int fireX = fireCurrent.x;
                int fireY = fireCurrent.y;

                for (int i=0; i<4; i++) {
                    int nextFireX = fireX + dx[i];
                    int nextFireY = fireY + dy[i];

                    if(nextFireX < 0 || nextFireY < 0 || nextFireX >= map[0].length || nextFireY >= map.length) continue;
                    if(!map[nextFireY][nextFireX].equals(".")) continue;
                    if(fireVisited[nextFireY][nextFireX]) continue;

                    fireVisited[nextFireY][nextFireX] = true;
                    map[nextFireY][nextFireX] = "*";
                    fireDeque.offerLast(new Node(nextFireX, nextFireY));
                }
            }

            //1턴에 모든 상근이 소모
            int manSize = manDeque.size();

            for(int j = 0; j < manSize; j++){
                Node current = manDeque.pollFirst();
                int currentX = current.x;
                int currentY = current.y;

                for(int i=0; i<4; i++){
                    int nextX = currentX + dx[i];
                    int nextY = currentY + dy[i];

                    //탈출
                    if(nextX < 0 || nextY < 0 || nextX >= map[0].length || nextY >= map.length){
                        return current.time + 1;
                    }

                    if(visited[nextY][nextX]) continue;
                    if(!map[nextY][nextX].equals(".")) continue;


                    visited[nextY][nextX] = true;
                    manDeque.offerLast(new Node(nextX, nextY,current.time + 1));
                }
            }
        }
        return -1;
    }

    private static class Node{
        int x;
        int y;
        int time;
        Node(int x, int y){
            this.x = x;
            this.y = y;
            this.time = 0;
        }
        Node(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

}
