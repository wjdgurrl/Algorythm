package study.BACKTRACKING;
import java.util.*;
import java.io.*;

public class problem_9663 {

    public static boolean[] visited; //그냥 행 기준 방문
    public static boolean[] visited2; // ↗대각선
    public static boolean[] visited3; // ↘대각선
    public static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        cnt = 0;
        visited = new boolean[N];
        visited2 = new boolean[2*N];
        visited3 = new boolean[2*N];
        dfs(0,N);
        System.out.println(cnt);
    }
    /*
    ㅁㅁㅁㅁㅁ
    ㅁㅁㅁㅁㅁ
    ㅁㅁㅁㅁㅁ
    ㅁㅁㅁㅁㅁ
    ㅁㅁㅁㅁㅁ
    */

    public static void dfs(int depth,int N){
        if(depth == N){
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            //퀸 둘수 있는 지 판별하기
            if(visited[i] || visited2[i+depth] || visited3[depth-i+N-1]){
                continue;
            }
            visited[i] = true;
            visited2[i+depth] = true;
            visited3[depth-i+N-1] = true;
            dfs(depth+1,N);
            visited[i] = false;
            visited2[i+depth] = false;
            visited3[depth-i+N-1] = false;
        }
    }
}
