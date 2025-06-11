package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/14890
public class problem_14890 {
    private static int N;
    private static int L;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        L = Integer.parseInt(line[1]);
        int count = 0;
        fillMap(br);

        //->
        for (int i = 0; i < N; i++) {
            if(findSlide(map[i])) count++;
        }
        //↓
        for (int i = 0; i < N; i++) {
            int[] newLine = new int[N];
            for(int j = 0; j < N; j++) newLine[j] = map[j][i];
            if(findSlide(newLine)) count++;
        }
        System.out.println(count);
    }

    //경사로 찾기
    private static boolean findSlide(int[] line) {
        boolean[] isSlide = new boolean[N];
        // ->
        for (int i = 0; i < N - 1 ; i++) {
            int cur = line[i];
            int next = line[i + 1];

            //차이가 0
            if (cur == next) continue;

            //차이가 1이상
            if (Math.abs(cur - next) > 1) return false;

            //차이가 +1 오르막
            if (cur + 1 == next) {
                for (int j = 0; j < L; j++) {
                    int idx = i - j; //자기부터 검사
                    if (idx < 0 || line[idx] != cur || isSlide[idx]) return false;
                    isSlide[idx] = true;
                }
            } else if (cur - 1 == next) { //차이가 -1 내리막
                for (int j = 1; j <= L; j++) {
                    int idx = i + j;
                    if (idx >= N || line[idx] != cur - 1 || isSlide[idx]) return false;
                    isSlide[idx] = true;
                }
            }
        }
        return true;
        //↓
        /*for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int cur = map[y][x];

                int nextX = map[y][x + dx[1]];
                if (nextX < 0 || nextX >= N) break;

                //차이가 0
                if (cur == nextX) continue;

                //차이가 1이상
                if (Math.abs(cur - nextX) > 1) continue;

                //차이가 +1 오르막
                if(cur + 1 == nextX) {
                    for (int i = 0; i < L; i++) {
                        int idx = x - i; //자기부터 검사
                        if(idx < 0 || map[y][idx] != cur || isSlide[y][idx]) break;
                        isSlide[y][idx] = true;
                    }
                } else if(cur -1 == nextX) { //차이가 -1 내리막
                    for(int i = 1; i <= L; i++) {
                        int idx = x + i;
                        if(idx >= N || map[y][idx] != cur -1 || isSlide[y][idx]) break;
                        isSlide[y][idx] = true;
                    }
                }
            }
        }*/
    }

    private static void fillMap(BufferedReader br) throws IOException {
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
    }
}
