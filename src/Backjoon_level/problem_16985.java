package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/16985
public class problem_16985 {
    private static int[] dx = {0, 0, -1, 1, 0, 0};
    private static int[] dy = {1, -1, 0, 0, 0, 0};
    private static int[] dz = {0, 0, 0, 0, -1, 1};
    private static int min = Integer.MAX_VALUE;
    private static ArrayList<Floor> arr = new ArrayList<Floor>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            int[][] maze = new int[5][5];
            for (int j = 0; j < 5; j++) {
                String[] line = br.readLine().split(" ");
                for (int k = 0; k < 5; k++) {
                    maze[j][k] = Integer.parseInt(line[k]);
                }
            }
            arr.add(new Floor(maze));
        }
        stackMaze(0,new boolean[5],new Floor[5]);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);

    }

    //판 5개 쌓기
    //5!
    private static void stackMaze(int depth, boolean[] visited, Floor[] stacked){
        if(depth == 5){
            //rotate 구현
            rotateAll(0,stacked,new int[5]);
            return;
        }

        for (int i = 0; i < 5; i++) {
            if(!visited[i]){
                visited[i] = true;
                stacked[depth] = arr.get(i).getFloor();
                stackMaze(depth + 1, visited, stacked);
                visited[i] = false;
            }
        }
    }

    private static void rotateAll(int depth, Floor[] stacked,int[] rotation ){
        if(depth == 5){
            Floor[] rotatedStacked = new Floor[5];
            for(int i = 0; i < 5; i++) {
                rotatedStacked[i] = stacked[i].getFloor();
                for (int r = 0; r < rotation[i]; r++) {
                    rotatedStacked[i].rotateRight();
                }
            }
            if(rotatedStacked[0].maze[0][0] == 1 && rotatedStacked[4].maze[4][4] == 1){
                bfs(rotatedStacked);
            }
            return;
        }
        for(int r = 0; r < 4; r++){
            rotation[depth] = r;
            rotateAll(depth + 1, stacked, rotation);
        }
    }

    private static void bfs(Floor[] stacked){
        boolean[][][] visited = new boolean[5][5][5];
        ArrayDeque<Point> points = new ArrayDeque<Point>();
        points.offerLast(new Point(0,0,0,0));
        visited[0][0][0] = true;

        while(!points.isEmpty()){
            Point currentPoint = points.pollFirst();
            if(currentPoint.z == 4 && currentPoint.y == 4 && currentPoint.x == 4){
                min = Math.min(min, currentPoint.dist);
                return;
            }

            for (int i = 0; i < 6; i++) {
                int nextZ = currentPoint.z + dz[i];
                int nextY = currentPoint.y + dy[i];
                int nextX = currentPoint.x + dx[i];

                if(nextZ < 0 || nextY < 0 || nextX < 0 ||nextZ >= 5 || nextY >= 5 || nextX >= 5){
                    continue;
                }

                if(stacked[nextZ].maze[nextY][nextX] == 0){
                    continue;
                }

                if(visited[nextZ][nextY][nextX]){
                    continue;
                }

                visited[nextZ][nextY][nextX] = true;
                points.offerLast(new Point(nextZ, nextY, nextX, currentPoint.dist + 1));
            }
        }
    }



    private static class Floor{
        private int[][] maze;

        Floor(int[][] maze){
            this.maze = maze;
        }

        Floor getFloor(){
            int[][] copy = new int[5][5];
            for (int i = 0; i < 5; i++) {
                copy[i] = Arrays.copyOf(maze[i], 5);
            }
            return new Floor(copy);
        }

        private void rotateRight(){
            //우측 90도 회전
            //0,0 - > 0,4
            //0,1 -> 1,4
            //0,2 -> 2,4
            int[][] temp = new int[maze.length][maze[0].length];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    temp[i][j] = this.maze[4-j][i];
                }
            }
            this.maze = temp;
        }
    }
    private static class Point{
        int z;
        int y;
        int x;
        int dist;
        Point(int z, int y, int x, int dist){
            this.z = z;
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
}
