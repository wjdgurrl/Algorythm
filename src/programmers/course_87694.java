package programmers;

import java.util.*;
import java.io.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/87694?language=java
public class course_87694 {
    private static int size = 20;
    private static int[][] graph;
    private static boolean[][] visited;
    private static int[] dx = new int[]{0,0,1,-1};
    private static int[] dy = new int[]{1,-1,0,0};

    public static void main(String[] args) {
        course_87694 aa = new course_87694();
        System.out.println(aa.solution(new int[][]{{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}}, 1,3,7,8));
    }

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        graph = new int[size][size]; //2배로
        visited = new boolean[size][size];
        fillGraph(rectangle);
        System.out.println(Arrays.deepToString(graph));
        return bfs(characterX*2, characterY*2, itemX*2, itemY*2);
    }
    //1 1 7 4 -> (1,1) , (7,1) , (1,4) , (7,4)
    //            x1,y1   x2,y1  x1,y2 , x2,y2
    //            y1 -> y2

    //bfs
    public static int bfs(int characterX, int characterY, int itemX, int itemY) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        //시작지점 넣기
        deque.offerLast(new int[]{characterX, characterY, 0});
        visited[characterX][characterY] = true;

        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int cur_x = cur[0];
            int cur_y = cur[1];

            if(cur_x == itemX && cur_y == itemY) {
                return cur[2] / 2;
            }

            for(int i = 0; i < 4; i++){
                int next_x = cur_x + dx[i];
                int next_y = cur_y + dy[i];

                if(next_x >= 0 && next_x < size && next_y >= 0 && next_y < size) {
                    if(!visited[next_x][next_y] && graph[next_x][next_y] == 1) {
                        visited[next_x][next_y] = true;
                        deque.offerLast(new int[]{next_x, next_y, cur[2] + 1});
                    }
                }
            }
        }
        return -1;
    }

    //그래프에 도형 채우기
    public static void fillGraph(int[][] rectangle) {
        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;

            //전부 2로 칠하기
            for(int j = x1; j <= x2; j++) {
                for (int k = y1; k <= y2; k++) {
                    graph[j][k] = 2;
                }
            }

        }
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int i = x1; i <= x2; i++) {
                if (graph[i][y1] == 2) graph[i][y1] = 1;
                if (graph[i][y2] == 2) graph[i][y2] = 1;
            }
            for (int j = y1; j <= y2; j++) {
                if (graph[x1][j] == 2) graph[x1][j] = 1;
                if (graph[x2][j] == 2) graph[x2][j] = 1;
            }
        }
    }
}