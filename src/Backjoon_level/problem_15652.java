package Backjoon_level;

import java.util. *;
import java.io. *;

//https://www.acmicpc.net/problem/15652
public class problem_15652 {
    static int N,M;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        arr = new int[M];
        dfs(0,1, 1);
        System.out.print(sb);
    }

    public static void dfs(int depth,int start, int min){
        if(depth == M){
            for (int i = 0; i < M ; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            if(i < min) continue;
            arr[depth] = i;
            dfs(depth + 1, start, i);
        }

    }
}
