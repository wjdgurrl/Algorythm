package study.DP;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/1932
public class problem_1932 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int d = 0;
        int[] triangles = new int[(n*(n+1))/2];
        int[] dp = triangles.clone();
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                triangles[d++] = Integer.parseInt(line[j]);
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
