package study.BFS;

import java.util. *;
import java.io. *;

//https://www.acmicpc.net/problem/6593
public class problem_6593 {

    //동서남북상하
    private static int[] dx = {0,0,-1,1,0,0}; //c
    private static int[] dy = {-1,1,0,0,0,0}; //r
    private static int[] dz = {0,0,0,0,-1,1}; //l

    private static ArrayList<Case> testCases;//테스트 케이스들

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isFinished = false;
        testCases = new ArrayList<>();
        while(!isFinished){
            //입력
            isFinished = readInput(br);
            if(isFinished) break;
        }

        //BFS
        for (Case testCase : testCases) {
            int i = BFS(testCase);
            if(i == -1){
                System.out.println("Trapped!");
            }else{
                System.out.println("Escaped in " + i + " minute(s).");
            }
        }

    }

    private static int BFS(Case testCase) {
        //현재 케이스
        int[] start = testCase.start;

        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.offerLast(new Node(start[0],start[1],start[2],0));
        testCase.visited[start[0]][start[1]][start[2]] = true;

        while(!deque.isEmpty()){
            Node current = deque.pollFirst();

            if(testCase.map[current.l][current.r][current.c].equals("E")){
                //탈출
                return current.time;
            }


            for(int i = 0; i < 6; i++){
                int nextL = current.l + dz[i];
                int nextR = current.r + dy[i];
                int nextC = current.c + dx[i];

                if(nextL < 0 || nextR < 0 || nextC < 0 || nextL >= testCase.L || nextR >= testCase.R || nextC >= testCase.C) continue;
                if(testCase.visited[nextL][nextR][nextC]) continue;
                if(testCase.map[nextL][nextR][nextC].equals("#")) continue;

                testCase.visited[nextL][nextR][nextC] = true;
                deque.offerLast(new Node(nextL,nextR,nextC, current.time + 1));
            }

        }
        return -1;
    }


    private static boolean readInput(BufferedReader br) throws IOException{
        String isEmpty = br.readLine();
        if(isEmpty.isEmpty()) return false;

        String[] line = isEmpty.split(" ");
        int L = Integer.parseInt(line[0]); //층
        if(L == 0) return true;
        int R = Integer.parseInt(line[1]);
        int C = Integer.parseInt(line[2]);

        //리스트에 넣을 Case 하나 선언해서 채우기
        Case cs = new Case(L,R,C);
        //맵 넣기
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                String input = br.readLine();
                while (input == null || input.isEmpty()) input = br.readLine();
                for (int k = 0; k < C; k++) {
                    String ch = input.substring(k, k+1);
                    cs.setMap(i, j, k, ch);
                    if (ch.equals("S")) {
                        cs.setStart(i, j, k);
                    }
                }
            }
            br.readLine(); //빈줄 처리
        }


        testCases.add(cs);

        return false;
    }

    //데크용 노드
    private static class Node{
        private int l;
        private int r;
        private int c;
        private int time;

        Node(int l, int r, int c, int time){
            this.l = l;
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    //[l][r][c]
    private static class Case{
        private int L;
        private int R;
        private int C;

        private int[] start;

        private String[][][] map;
        private boolean[][][] visited;

        private Case(int L,int R,int C){
            this.L = L;
            this.R = R;
            this.C = C;

            this.start = new int[3];

            this.map = new String[L][R][C];
            this.visited = new boolean[L][R][C];
        }

        private void setStart(int i, int j,int k){
            this.start[0] = i;
            this.start[1] = j;
            this.start[2] = k;
        }

        private void setMap(int L, int R, int C, String input){
            this.map[L][R][C] = input;
        }

    }
}
