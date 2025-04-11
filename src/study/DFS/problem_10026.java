package study.DFS;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/10026
public class problem_10026 {

    private static int N;
    private static String[][] graph;
    private static String[][] graphRG;
    private static boolean[][] visited;
    private static boolean[][] visitedRG;
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new String[N][N];
        graphRG = new String[N][N];
        visited = new boolean[N][N];
        visitedRG = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                graph[i][j] = row[j];
                graphRG[i][j] = row[j].equals("G") ? "R" : row[j];
            }
        }
        int count = 0;
        int count2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, graph, visited);
                    count++;
                }
                if (!visitedRG[i][j]) {
                    dfs(i, j, graphRG, visitedRG);
                    count2++;
                }
            }
        }

        System.out.println(count + " " + count2);
    }

    private static void dfs(int x, int y, String[][] graph, boolean[][] visited) {
        visited[x][y] = true;
        String color = graph[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (visited[nx][ny]) continue;
            if (!graph[nx][ny].equals(color)) continue;

            dfs(nx, ny, graph, visited);
        }
    }
}
