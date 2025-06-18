package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/15684
public class problem_15684 {
    public static int[][] map;
    public static int N;
    public static int M;
    public static int H;
    public static int answer;

    //public static int[] dx = {1,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]); //세로 x축
        M = Integer.parseInt(line[1]); // 가로 y축
        H = Integer.parseInt(line[2]); // 사다리
        answer = 4;
        fillMap(br);

        dfs(0,1);
        System.out.println(answer > 3 ? -1 : answer);
    }

    //dfs로 사다리 타기
    public static void dfs(int depth, int y){
        if(depth >= answer) return;
        if(findLadder()){
            answer = depth;
            return;
        }
        if(depth == 3) return;

        for (int i = y; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1;
                    map[i][j + 1] = 2;
                    dfs(depth + 1, i);

                    map[i][j] = 0;
                    map[i][j + 1] = 0;
                }
            }
        }


    }

    // 칸 옆에 검사
    // 어짜피 내려가는거 끝가지 고려 x
    public static boolean findLadder(){
        for (int i = 1; i <= N; i++) {
            int cur = i;

            for (int j = 1; j <= H; j++) {
                if(map[j][cur] == 1) cur++;
                else if(map[j][cur] == 2) cur--;
            }
            if(cur != i) return false;
        }
        return true;
    }



    public static void fillMap(BufferedReader br) throws IOException {
        map = new int[H + 2][N + 2];

        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            map[a][b] = 1;  // b - b+1
            map[a][b + 1] = 2;
        }
    }
}
