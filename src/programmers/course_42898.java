package programmers;

import java.util.*;

public class course_42898 {
    public static void main(String[] args) {
        course_42898 aa = new course_42898();
        System.out.println(aa.solution(4,3, new int[][]{{2,2}}));
        //[h][x][x][x]
        //[x][Z][x][x]  --> puddles
        //[x][x][x][d]
        // -1은 물 2은 도착지
    }
    public int solution(int m, int n, int[][] puddles){
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        int[][] map = new int[n][m];
        setMap(map,n);
        map[puddles.length][puddles[0].length-1] = -1;
        map[n-1][m-1] = 2; // 도착지
        answer = course(m,n,map);
        return answer;
    }
    public static void setMap(int[][] map,int n){
        for (int i = 0; i < n; i++) {Arrays.fill(map[i],0);}
    }
    public static int course(int m,int n,int[][] map){
        if(map[0][1] == 0) map[0][1] = 1;//우측 이동
        if(map[1][0] == 0) map[1][0] = 1;//아래 이동

        for (int i = 1; i < n ; i++) {
            for (int j = 1; j < m; j++) {
                if(map[i][j] == -1) continue;
                if(map[i][j-1] != -1){
                    map[i][j] = map[i][j] + map[i][j-1];
                }
                if(map[i-1][j] != -1){
                    map[i][j] = map[i][j] + map[i-1][j];
                }
            }
        }
        return map[n][m];
    }
}
