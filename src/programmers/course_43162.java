package programmers;
import java.util.*;
import java.io.*;

public class course_43162 {
    /*public static void main(String[] args)throws IOException {
        int n = 4;
        int[][] computer = new int[][]{{1,1,0,1},{1,1,0,0},{0,0,1,1},{1,0,1,1}};
        System.out.println(network(n,computer));
    }
    public static int network(int n,int[][] computers){
        boolean[][] check2 = new boolean[n][n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i !=j && computers[i][j] == computers[j][i]&& computers[i][j] == 1){
                    check2[i][j] = true;
                }
                if(check2[i][j] == check2[j][i] && check2[i][j]){
                    answer++;
                }
            }
        }
        System.out.println((Arrays.deepToString(check2)));
        return answer;
    }*/
    static int[] visit;
    public static void main(String[] args) {
        int n = 4;
        int answer = 0;
        int[][] computers = {{1,1,0,1},{1,1,0,0},{0,0,1,1},{1,0,1,1}};
        visit = new int[n]; // 방문
        for (int i = 0; i < n; i++) {
            if (visit[n] == 0){
                DFS(computers,visit,n);
                answer ++;
            }
        }
    }
    static void DFS(int[][] computers,int[] visit, int i){

    }
}
