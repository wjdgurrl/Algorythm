package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/14502
public class problem_14502 {
    private static int[][] map;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static int maxSafe = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        map = new int[N][M];
        readInput(br);

        ArrayList<Wall> walls = new ArrayList<>(); //y,x
        ArrayList<Wall> virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    walls.add(new Wall(i, j));
                }
                if(map[i][j] == 2) {
                    virus.add(new Wall(i, j));
                }
            }
        }

        for (int i = 0; i < walls.size(); i++) {
            for (int j = i + 1; j < walls.size(); j++) {
                for (int k = j + 1; k < walls.size(); k++) {
                    map[walls.get(i).y][walls.get(i).x] = 1;
                    map[walls.get(j).y][walls.get(j).x] = 1;
                    map[walls.get(k).y][walls.get(k).x] = 1;

                    //bfs
                    bfs(virus);

                    map[walls.get(i).y][walls.get(i).x] = 0;
                    map[walls.get(j).y][walls.get(j).x] = 0;
                    map[walls.get(k).y][walls.get(k).x] = 0;

                }
            }
        }

        System.out.println(maxSafe);
    }

    private static void bfs(ArrayList<Wall> virus) {
        //int[][] copiedMap = map.clone(); 얕은 복사 ㅌ
        int[][] copiedMap = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            copiedMap[i] = map[i].clone();
        }

        ArrayDeque<Wall> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[map.length][map[0].length];

        for (Wall Virus : virus){
            deque.offerLast(Virus);
            visited[Virus.y][Virus.x] = true;
        }

        while(!deque.isEmpty()) {
            Wall current = deque.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nextY = current.y + dy[i];
                int nextX = current.x + dx[i];

                if(nextY < 0 || nextX < 0 || nextY >= map.length || nextX >= map[0].length) continue;
                if(visited[nextY][nextX]) continue;

                //감염
                if(copiedMap[nextY][nextX] == 0){
                    copiedMap[nextY][nextX] = 2;
                    visited[nextY][nextX] = true;
                    deque.offerLast(new Wall(nextY, nextX));
                }

            }
        }

        int safeArea = 0;
        for (int i = 0; i < copiedMap.length; i++) {
            for (int j = 0; j < copiedMap[0].length; j++) {
                if(copiedMap[i][j] == 0) safeArea++;
            }
        }

        maxSafe = Math.max(safeArea, maxSafe);




    }


    private static void readInput(BufferedReader br) throws IOException {
        for (int i = 0; i < map.length; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
    }

    private static class Wall{
        int y;
        int x;

        Wall(int y, int x){
            this.y = y;
            this.x = x;
        }

    }
}
