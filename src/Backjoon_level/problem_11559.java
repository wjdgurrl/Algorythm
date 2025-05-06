package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/11559
public class problem_11559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] map;
        map = fillMap(br);
        System.out.println(Arrays.deepToString(map));

    }

    private static String[][] fillMap(BufferedReader br) throws IOException {
        String[][] map = new String[12][6];
        for (int i = 0; i < 12; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < 6; j++) {
                map[i][j] = line[j];
            }
        }
        return map;
    }
}
