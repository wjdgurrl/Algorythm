package Discord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class problem_14499 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();

        //칸마다 숫자
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = in.nextInt();

        //동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4로 주어진다.
        int[] state =  new int[2];
        int up = 1;
        int down = 6;

        Dice.roll(N,M,br);


    }
}

class Dice{
    static void roll(int n, int m,BufferedReader br) throws IOException {
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num; //맵 채우기
            }
        }




    }
}