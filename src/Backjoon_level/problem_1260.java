package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/1260
public class problem_1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //정점
        int M = Integer.parseInt(st.nextToken()); //간선
        int V = Integer.parseInt(st.nextToken()); //스타트
        int[][] graph = new int[N + 1][N + 1]; //1~N

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //양방향
            /*
            [0][1][0]
            [1][0][1]
            [0][1][0]
            */
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        executeAlgorithm dfs = new DFS(graph,N);
        dfs.execute(V);

        System.out.println();

        executeAlgorithm bfs = new BFS(graph,N);
        bfs.execute(V);
    }

    //인터페이스
    interface executeAlgorithm {
        void execute(int start);
    }

    public static class Algorythm {
        int[][] graph;
        boolean visited[];
        int size;

        public Algorythm(int[][] graph, int size) {
            this.graph = graph;
            this.size = size;
            this.visited = new boolean[size + 1];
        }
    }
    static class BFS extends Algorythm implements executeAlgorithm{
        public BFS(int[][] graph, int size) {
            super(graph, size);
        }

        @Override
        public void execute(int start) {
            Arrays.fill(visited, false);
            bfs(start);
        }

        private void bfs(int start) {
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            deque.offerLast(start);
            visited[start] = true;

            while (!deque.isEmpty()) {
                int cur = deque.pollFirst();
                System.out.print(cur + " ");

                for (int i = 1; i <= size ; i++) {
                    if(graph[cur][i] == 1 && !visited[i]) {
                        deque.offerLast(i);
                        visited[i] = true;
                    }
                }
            }

        }

    }
    static class DFS extends Algorythm implements executeAlgorithm{
        public DFS(int[][] graph, int size) {
            super(graph, size);
        }

        @Override
        public void execute(int start) {
            Arrays.fill(visited, false);
            dfs(start);
        }

        private void dfs(int node){
            visited[node] = true; //방문 처리
            System.out.print(node+" ");

            for (int i = 1; i <= size ; i++) {
                if(graph[node][i] == 1 && !visited[i]){
                    dfs(i);
                }
            }

        }

    }
}
