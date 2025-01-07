package study.BACKTRACKING;

import java.util.*;
import java.io.*;

//스택구조라서 역순으로 나옴
/*public class problem_15649 {
    private static ArrayDeque<Node> stack;
    private static int N;
    private static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        *//*int temp = 1;
        //1부터 n까지 중복되지 않은 m개를 고른 수열
        //1 2 3 중에 1개는 !(N-1)\ 무조건 1개 씩만 가능해
        //1 2 3 4 중에 2개 처음엔 4개 선택 그다음거엔 3개 그래서 4X3 12
        //1 2 3 4 중에 4개 처음엔 4개 3개 2개 1개 해서 4X3X2X1 24
        for (int i = N; i > N - M; i--) {
            temp *= i;
        }
        int[] answer = new int[temp];*//*
        stack = new ArrayDeque<>();
        //초기 스택 삽입
        stack.addFirst(new Node(0,new int[M], new boolean[N+1]));
        //dfs
        while (!stack.isEmpty()) {
            Node current = stack.removeFirst();//pop해준걸 현재 노드에 저장

            if(current.depth == M){ //깊이가 M이면 중단
                for (int num : current.array){
                    System.out.print(num + " ");
                }
                System.out.println();
                continue;
            }

            for (int i = 1; i <= N; i++) { // 그래프 이동
                if(!current.visited[i]){//방문 여부 확인
                    current.visited[i] = true;//방문 처리
                    current.array[current.depth] = i; //현재 깊이에 숫자 저장
                    stack.addFirst(new Node(current.depth+1, current.array, current.visited)); //다음 노드 추가
                    current.visited[i] = false; //백트래킹
                }
            }
        }
    }
    static class Node{
        int depth;
        int[] array; //현재 선택된 숫자들을 저장해주는 배열
        boolean[] visited;

        Node(int depth, int[] array, boolean[] visited){
            this.depth = depth;
            this.array = array.clone(); //독립적으로 해야되니까 참조복사말고 값복사를 해야함
            this.visited = visited.clone();
        }
    }

}*/

//stack없이 구현

public class problem_15649 {
    private static boolean[] visited;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        visited = new boolean[N + 1];

        dfs(0, new int[M]);
    }

    public static void dfs(int depth, int[] sequence) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int num : sequence) {
                sb.append(num).append(" ");
            }
            System.out.println(sb.toString().trim());
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequence[depth] = i;
                dfs(depth + 1, sequence);
                visited[i] = false;
            }
        }
    }
}





















