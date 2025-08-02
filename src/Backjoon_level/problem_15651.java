package Backjoon_level;

import java.util. *;
import java.io. *;

//https://www.acmicpc.net/problem/15651
public class problem_15651 {
    static int N,M;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        sb = new StringBuilder();
        dfs(0);
        System.out.print(sb);

    }

    private static void dfs(int depth){
        if(depth == M){
            for (int a : arr){
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[depth] = i;
            dfs(depth + 1 );
        }

    }
}
