package programmers;

import java.util.*;
import java.io.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/87694?language=java
public class course_87694 {
    private static int size;
    private static int[][] graph;
    private static boolean[][] visited;
    private static int[] dx = new int[]{0,0,1,-1};
    private static int[] dy = new int[]{1,-1,0,0};

    public static void main(String[] args) {
        course_87694 aa = new course_87694();
        System.out.println(aa.solution(new int[][]{{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}}, 1,3,7,8));
    }

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        int maxCoord = 0;
        for (int[] rect : rectangle) {
            maxCoord = Math.max(maxCoord, Math.max(rect[2], rect[3]));
        }
        size = (maxCoord * 2) + 1;

        graph = new int[size][size]; //2배로
        visited = new boolean[size][size];
        fillGraph(rectangle);
        System.out.println(Arrays.deepToString(graph));
        return bfs(characterY*2, characterX*2, itemY*2, itemX*2);
    }
    //1 1 7 4 -> (1,1) , (7,1) , (1,4) , (7,4)
    //            x1,y1   x2,y1  x1,y2 , x2,y2
    //            y1 -> y2

    //bfs
    public static int bfs(int characterY, int characterX, int itemY, int itemX) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        //시작지점 넣기
        deque.offerLast(new int[]{characterY, characterX, 0});
        visited[characterY][characterX] = true;

        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int cur_y = cur[0];
            int cur_x = cur[1];

            if(cur_x == itemX && cur_y == itemY) {
                return cur[2] / 2;
            }

            for(int i = 0; i < 4; i++){
                int next_x = cur_x + dx[i];
                int next_y = cur_y + dy[i];

                if(next_y >= 0 && next_y < size && next_x >= 0 && next_x < size) {
                    if(!visited[next_y][next_x] && graph[next_y][next_x] == 1) {
                        visited[next_y][next_x] = true;
                        deque.offerLast(new int[]{next_y, next_x, cur[2] + 1});
                    }
                }
            }
        }
        return -1;
    }

    //그래프에 도형 채우기
    public static void fillGraph(int[][] rectangle) {
        for (int[] ints : rectangle) {
            int x1 = ints[0] * 2;
            int y1 = ints[1] * 2;
            int x2 = ints[2] * 2;
            int y2 = ints[3] * 2;

            //전부 2로 칠하기
            for (int y = y1; y <= y2; y++) {
                for (int x = x1; x <= x2; x++) {
                    graph[y][x] = 2;
                }
            }

        }
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int x = x1; x <= x2; x++) {
                if (graph[y1][x] == 2) graph[y1][x] = 1;
                if (graph[y2][x] == 2) graph[y2][x] = 1;
            }
            for (int y = y1; y <= y2; y++) {
                if (graph[y][x1] == 2) graph[y][x1] = 1;
                if (graph[y][x2] == 2) graph[y][x2] = 1;
            }
        }

        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int y = y1 + 1; y < y2; y++) {
                for (int x = x1 + 1; x < x2; x++) {
                    // 겹치는 사각형의 내부인 경우 0으로 만들어 이동 불가능하게 함
                    if (graph[y][x] == 1) {
                        graph[y][x] = 0;
                    }
                }
            }
        }

    }
}