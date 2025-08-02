package Backjoon_level;


import java.util. *;
import java.io. *;


//https://www.acmicpc.net/problem/15650
public class problem_15650 {
    private static int N,M;
    private static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        //1부터 N까지 중복없이 m개를 고른 수열
        arr = new int[M];

        dfs(0,1);

    }
    public static void dfs(int depth, int start){
        if(depth == M){
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i <= N; i++){
            arr[depth] = i;
            dfs(depth+1, i + 1);
        }
    }
}
