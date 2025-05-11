package Backjoon_level;

import java.util. *;
import java.io. *;

//https://www.acmicpc.net/problem/14499
public class problem_14499 {
    private static int[][] map;
    private static int[] dx = {0, 1, -1, 0, 0};
    private static int[] dy = {0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        ArrayDeque<Integer> orders = new ArrayDeque<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int y = Integer.parseInt(st.nextToken()); //주사위 x좌표
        int x = Integer.parseInt(st.nextToken()); //주사위 y좌표
        makeBoard(br);
        int order = Integer.parseInt(st.nextToken()); //명령 개수
        st = new StringTokenizer(br.readLine()," ");

        while(st.hasMoreTokens()){
            orders.offerLast(Integer.parseInt(st.nextToken()));
        }
        moveBoard(orders,x,y);
        //동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4로 주어진다.

        /*map
        [0][2]
        [3][4]
        [5][6]
        [7][8]
        * */
    }

    private static void moveBoard(ArrayDeque<Integer> orders,int x, int y){
        Dice dice = new Dice(); //주사위
        int curX = x;
        int curY = y;
        while(!orders.isEmpty()){
            int currentOrder = orders.pollFirst();
            int nextX = curX + dx[currentOrder];
            int nextY = curY + dy[currentOrder];

            if(nextX < 0 || nextY < 0 || nextX >= map[0].length || nextY >= map .length) continue;
            switch (currentOrder){
                case 1: dice.moveRight();break;
                case 2: dice.moveLeft(); break;
                case 3: dice.moveUp(); break;
                case 4: dice.moveDown(); break;
            }
            System.out.println(dice.getTop());
            map[nextY][nextX] = dice.checkBoard(map[nextY][nextX]);
            curX = nextX;
            curY = nextY;
        }

    }

    private static void makeBoard(BufferedReader br)throws IOException{
        for (int i = 0; i < map.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static class Dice{
        private int[] dice;

        private Dice(){
            this.dice = new int[]{0,0,0,0,0,0};
            /*0 - 위
              1 - 아래
              2 - 북
              3 - 남
              4 - 서
              5 - 동
             */
        }

        private int getTop(){
            return this.dice[0];
        }

        private void moveLeft(){
            int temp = dice[0];
            dice[0] = dice[5];
            dice[5] = dice[1];
            dice[1] = dice[4];
            dice[4] = temp;
        }
        private void moveRight(){
            int temp = dice[0];
            dice[0] = dice[4];
            dice[4] = dice[1];
            dice[1] = dice[5];
            dice[5] = temp;
        }
        private void moveUp(){
            int temp = dice[0];
            dice[0] = dice[3];
            dice[3] = dice[1];
            dice[1] = dice[2];
            dice[2] = temp;
        }
        private void moveDown(){
            int temp = dice[0];
            dice[0] = dice[2];
            dice[2] = dice[1];
            dice[1] = dice[3];
            dice[3] = temp;
        }
        private int checkBoard(int boardNum){
            if(boardNum == 0){
                return this.dice[1];
            }
            this.dice[1] = boardNum;
            return 0;
        }
    }


}
