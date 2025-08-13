package Backjoon_level;

import java.util. *;
import java.io. *;

//https://www.acmicpc.net/problem/15655
public class problem_15655 {
    private static int[] list;
    private static int[] arr;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new int[N];
        arr = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        br.close();
        dfs(0,N,M,list[0]);
    }
    private static void dfs(int depth, int N, int M, int minNum){
        if(depth == M){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            System.out.println(sb.toString().trim());
            return;
        }

        for (int i = 0; i < N; i++) {
            if(visited[i]) continue;
            if(minNum > list[i]) continue;

            visited[i] = true;
            arr[depth] = list[i];
            minNum = list[i];
            dfs(depth+1, N,M, minNum);
            visited[i] = false;
        }
    }
}
