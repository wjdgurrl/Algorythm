package study.BFS;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/5014
public class problem_5014 {

    private static int[] building;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int F = Integer.parseInt(line[0]); // 총 층 개수
        int S = Integer.parseInt(line[1]); // 강호 현재 층
        int G = Integer.parseInt(line[2]); // 사무실 층
        int U = Integer.parseInt(line[3]); // 위로 u만큼 올라가는 버튼
        int D = Integer.parseInt(line[4]); // 아래로 d만큼 내려가는 버튼
    }
    /*
    u - 2 d - 1
    [10] g
    [9]
    [8]
    [7]
    [6]
    [5]
    [4]
    [3]
    [2]
    [1] s
    [0]*/
}
