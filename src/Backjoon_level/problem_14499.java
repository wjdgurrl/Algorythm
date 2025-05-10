package Backjoon_level;

import java.util. *;
import java.io. *;

//https://www.acmicpc.net/problem/14499
public class problem_14499 {
    private static int[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int x = Integer.parseInt(st.nextToken()); //주사위 x좌표
        int y = Integer.parseInt(st.nextToken()); //주사위 y좌표
        int order = Integer.parseInt(st.nextToken()); //명령 개수
        //동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4로 주어진다.

        /*map
        [0][2]
        [3][4]
        [5][6]
        [7][8]
        * */
    }
    private static void moveDice(){

    }

    private static class Dice{
        private int[] dice;

        private Dice(){
            this.dice = new int[]{1,6,2,5,4,3};
            /*0 - 위
              1 - 아래
              2 - 북
              3 - 남
              4 - 서
              5 - 동
             */
        }
        private void rollDice(){
            rollDice();
        }



    }


}
