package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/16985
public class problem_16985 {
    private static int[] dx = {0, 0, -1, 1, 0, 0};
    private static int[] dy = {1, -1, 0, 0, 0, 0};
    private static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Floor> arr = new ArrayList<Floor>();
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
        System.out.println(Arrays.deepToString(arr.get(0).maze));
        arr.get(0).rotateRight();
        System.out.println(Arrays.deepToString(arr.get(0).maze));
    }
    private static class Floor{
        private int[][] maze;
        private boolean isVisited;
        private boolean[][] visited;

        Floor(int[][] maze){
            this.maze = maze;
            isVisited = false;
            visited = new boolean[maze.length][maze[0].length];
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
