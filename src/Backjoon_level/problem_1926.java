package Backjoon_level;

import java.util.*;
import java.io.*;

public class problem_1926 {
    //동서남북 돌기
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static boolean[][] visited;

    public static int n;
    public static int m;

    public static ArrayDeque<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        int num = 0;
        int maxNum = 0;
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }
        visited = new boolean[n][m];
        //먼저 좌표를 담을 큐를 생성해주기
        queue = new ArrayDeque<>();

        //첫 스타트 좌표 담기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //색칠이 안되있거나 방문한 경우 넘어감
                if (board[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                //탐색 해야 하는 경우
                num ++;//일단 그림은 찾았음

                maxNum = Math.max(maxNum,bfs(board,i,j)); // 최대 크기 찾기
            }
        }
        System.out.println(num);
        System.out.println(maxNum);
    }
    public static int bfs(int[][] board,int x, int y) {
        //먼저 방문처리 하고 큐에 넣음
        visited[x][y] = true;
        queue.offerLast(new int[]{x, y});
        int area = 0; //현재 그림의 크기

        //큐에 들어갔으니 해당 좌표를 기준으로 탐색 시작
        while (!queue.isEmpty()) {
            area++; //큐에서 하나 꺼낼때마다 그림 크기가 늘어나는 것
            int[] current = queue.pollFirst(); //현재 좌표 꺼내기
            int curX = current[0];
            int curY = current[1];

            //동서남북 탐색하기
            for (int i=0; i<4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                //범위를 벗어나는 경우
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m){
                    continue;
                }
                //이미 방문한 경우 + 보드판에 0이 그려진 경우
                if(visited[nextX][nextY] || board[nextX][nextY] == 0){
                    continue;
                }

                //다음에 방문한 예정일 곳 처리
                visited[nextX][nextY] = true;
                queue.offerLast(new int[]{nextX, nextY});
            }
        }
        return area;


    }
}
