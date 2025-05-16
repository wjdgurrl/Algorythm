package study.GREEDY;

import java.util.*;
import java.io.*;


//https://www.acmicpc.net/problem/2847
public class problem_2847 {
    private static int count;
    private static int maxLevel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        count = 0;
        int[] levels = new int[N];
        for (int i = 0; i < N; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }
        maxLevel = levels[N-1];
        for (int i = N-2; i >= 0; i--) {
            downGrade(levels[i]);
        }
        System.out.println(count);

    }

    public static int downGrade(int level) {
        if(level < maxLevel){
            maxLevel = level;
            return level;
        }
        level--;
        count++;
        downGrade(level);
        return -1;
    }
}
