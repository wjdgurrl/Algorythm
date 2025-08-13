package Backjoon_level;
import java.util. *;
import java.io. *;

//https://www.acmicpc.net/problem/15654
public class problem_15654 {

    private static int[] arr;
    private static int[] list;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());//1~N까지
        int M = Integer.parseInt(st.nextToken());//m
        
        arr = new int[M];
        visited = new boolean[N];

        list = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        dfs(0,N,M);
    }
    public static void dfs(int depth, int N, int M){
        if(depth == M){
            StringBuilder sb = new StringBuilder();
            for (int i : arr){
                sb.append(i).append(" ");
            }
            System.out.println(sb.toString().trim());
            return;
        }

        for (int i = 0; i < N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            arr[depth] = list[i];
            dfs(depth + 1, N,M);
            visited[i] = false;
        }
        
    }
}
