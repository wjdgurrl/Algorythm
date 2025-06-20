package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/15685
public class problem_15685 {
    static ArrayList<Curve> curves = new ArrayList<Curve>();
    static int[][] map = new int[100][100];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) readCurves(br);

        /*for(int i = 0; i < N; i++){
            System.out.println(curves.get(i).x + " " + curves.get(i).y + " " + curves.get(i).d +" " + curves.get(i).g);
        }*/


    }

    public static void fillMap(){
        for (int i = 0; i < curves.size(); i++) {
            int x = curves.get(i).x;
            int y = curves.get(i).y;
            int d = curves.get(i).d;
            int g = curves.get(i).g;

            ArrayList<Integer> beforeLine = new ArrayList<>();
            beforeLine.add(d); //역행영

            map[y][x] = 1; //시작

            for(int j = 1; j <= g; j++){
                for (int k = beforeLine.size() - 1; k >= 0 ; k--){
                    
                }

            }
        }
    }


    public static void readCurves(BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");
        int x = Integer.parseInt(line[0]);
        int y = Integer.parseInt(line[1]);
        int d = Integer.parseInt(line[2]);
        int g = Integer.parseInt(line[3]);
        curves.add(new Curve(x, y, d, g));
    }

    static class Curve{
        int x;
        int y;
        int d; //시작 방향
        int g; //세대
        Curve(int x, int y, int d, int g){
            this.x = x;
            this.y = y;
            this.d = d;
            this.g = g;
        }
    }
}
