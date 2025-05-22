package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/14500
public class problem_14500 {

    private static int[][] map;
    private static boolean[][] visited;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static int max;

    /*private static ArrayList<Polys> polys;*/

    //도형 넣어보고 돌려보기?
    //250000 * 10 == 2500000


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        fillMap(br);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                DFS(j,i,1,map[i][j]);
                visited[i][j] = false;
                max = Math.max(max,checkT(j,i));
            }
        }
        System.out.println(max);

    }

    /*private static void makePolys(){
        polys = new ArrayList<>();
        polys.add(new Polys(new int[]{0,1,2,3},new int[]{0,0,0,0})); //직사각
        polys.add(new Polys(new int[]{0,1,1,0},new int[]{0,0,1,1})); //정사각
        polys.add(new Polys(new int[]{0,0,0,1},new int[]{0,1,1,0}));
        polys.add(new Polys(new int[]{0,0,1,1},new int[]{0,1,0,1}));
        polys.add(new Polys(new int[]{0,1,1,-1},new int[]{0,0,0,1}));
    }*/

    public static void DFS(int x, int y, int depth, int sum){
        if (depth == 4) {
            max = Math.max(max,sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX >= map[0].length || nextY < 0 || nextY >= map.length) continue;
            if (visited[nextY][nextX]) continue;

            visited[nextY][nextX] = true;
            DFS(nextX,nextY,depth+1,sum + map[nextY][nextX]);
            visited[nextY][nextX] = false;
        }

    }

    //x > 1, y > 1 ,x < len,조건 걸기
    private static int checkT(int x, int y){
        int temp = 100000; //뺄 모양
        int count = 0;
        int score = map[y][x]; //가운데
        for (int i = 0; i < 4; i++) {

            if(x + dx[i] < 0 || y + dy[i] < 0 || x + dx[i] >= map[0].length || y + dy[i] >= map.length) continue;

            count ++;
            temp = Math.min(temp,map[y + dy[i]][x + dx[i]]);
            score += map[y + dy[i]][x + dx[i]]; //다 더하기
        }
        if(count == 4) score -= temp; //ㅗ 모양 완성
        if(count < 3) return 0;
        return score;
    }

    private static void fillMap(BufferedReader br) throws IOException {

        for (int i = 0; i < map.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = (Integer.parseInt(st.nextToken()));
            }
        }

    }

}
