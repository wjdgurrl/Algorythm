package study.BFS;

import java.util. *;
import java.io. *;

//https://www.acmicpc.net/problem/6593
public class problem_6593 {

    //동서남북상하
    private static int[] dx = {0,0,-1,1,0,0};
    private static int[] dy = {-1,1,0,0,0,0};
    private static int[] dz = {0,0,0,0,-1,1};

    private static ArrayList<Case> testCases;//테스트 케이스들

    public static void main(String[] args) throws IOException {
        boolean isFinished = false;
        testCases = new ArrayList<>();
        while(!isFinished){
            //입력
            isFinished = readInput();
            if(isFinished) return;
        }
    }

    private static boolean readInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int L = Integer.parseInt(line[0]); //층
        if(L == 0) return true;
        int R = Integer.parseInt(line[1]);
        int C = Integer.parseInt(line[2]);

        //리스트에 넣을 Case 하나 선언해서 채우기

        return false;
    }

    private static class Case{
        private int L;
        private int R;
        private int C;

        private static String[][][] map;
        private static boolean[][][] visited;

        private Case(int L,int R,int C){
            this.L = L;
            this.R = R;
            this.C = C;
            map = new String[L][R][C];
            visited = new boolean[L][R][C];
        }

        private void setMap(int L, int R, int C, String input){
            this.map[L][R][C] = input;
        }

    }
}
