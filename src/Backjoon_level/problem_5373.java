package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/5373
public class problem_5373 {

    private static ArrayList<Move> moves;
    private static String[][] cube;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            moves = new ArrayList<Move>();
            cube = new String[6][9]; // 0-up, 1-down, 2-front, 3-back, 4-left, 5-right   [][][],[][][],[][][]
            setCube();
            String[] line =  br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                Move move = new Move(line[i].charAt(0), line[i].charAt(1));
                moves.add(move);
            }

            for (int i = 0; i < moves.size(); i++) {
                Move move = moves.get(i);
                char side = move.side;
                char direction = move.direction;

                rotateCube(side, direction);
            }

            //출력
            for (int i = 0; i < 9; i+=3) {
                System.out.print(cube[0][i]);
                System.out.print(cube[0][i+1]);
                System.out.println(cube[0][i+2]);
            }

        }

    }

    public static void setCube() {
        String[] color = {"w","y","r","o","g","b"};
        for (int i = 0; i < 6; i++) {
            String sideColor = color[i];
            for (int j = 0; j < 9; j++) {
                cube[i][j] = sideColor;
            }
        }
    }

    public static void rotateFace(int faceIdx, char dir) {
        String[] temp = cube[faceIdx].clone();

        if (dir == '+') {
            cube[faceIdx][0] = temp[6];
            cube[faceIdx][1] = temp[3];
            cube[faceIdx][2] = temp[0];
            cube[faceIdx][3] = temp[7];
            cube[faceIdx][4] = temp[4];
            cube[faceIdx][5] = temp[1];
            cube[faceIdx][6] = temp[8];
            cube[faceIdx][7] = temp[5];
            cube[faceIdx][8] = temp[2];
        } else {
            cube[faceIdx][0] = temp[2];
            cube[faceIdx][1] = temp[5];
            cube[faceIdx][2] = temp[8];
            cube[faceIdx][3] = temp[1];
            cube[faceIdx][4] = temp[4];
            cube[faceIdx][5] = temp[7];
            cube[faceIdx][6] = temp[0];
            cube[faceIdx][7] = temp[3];
            cube[faceIdx][8] = temp[6];
        }
    }


    public static void rotateCube(char side, char direction){
        String[] temp;
        int i, j, k;

        switch(side){
            case 'U':
                rotateFace(0, direction);
                temp = new String[]{cube[4][0], cube[4][1], cube[4][2]};
                if(direction == '+'){
                    cube[4][0] = cube[2][0];
                    cube[4][1] = cube[2][1];
                    cube[4][2] = cube[2][2];

                    cube[2][0] = cube[5][0];
                    cube[2][1] = cube[5][1];
                    cube[2][2] = cube[5][2];

                    cube[5][0] = cube[3][0];
                    cube[5][1] = cube[3][1];
                    cube[5][2] = cube[3][2];

                    cube[3][0] = temp[0];
                    cube[3][1] = temp[1];
                    cube[3][2] = temp[2];
                } else {
                    cube[4][0] = cube[3][0];
                    cube[4][1] = cube[3][1];
                    cube[4][2] = cube[3][2];

                    cube[3][0] = cube[5][0];
                    cube[3][1] = cube[5][1];
                    cube[3][2] = cube[5][2];

                    cube[5][0] = cube[2][0];
                    cube[5][1] = cube[2][1];
                    cube[5][2] = cube[2][2];

                    cube[2][0] = temp[0];
                    cube[2][1] = temp[1];
                    cube[2][2] = temp[2];
                }
                break;

            case 'D':
                rotateFace(1, direction);
                temp = new String[]{cube[4][6], cube[4][7], cube[4][8]};
                if(direction == '+'){
                    cube[4][6] = cube[3][6];
                    cube[4][7] = cube[3][7];
                    cube[4][8] = cube[3][8];

                    cube[3][6] = cube[5][6];
                    cube[3][7] = cube[5][7];
                    cube[3][8] = cube[5][8];

                    cube[5][6] = cube[2][6];
                    cube[5][7] = cube[2][7];
                    cube[5][8] = cube[2][8];

                    cube[2][6] = temp[0];
                    cube[2][7] = temp[1];
                    cube[2][8] = temp[2];
                } else {
                    cube[4][6] = cube[2][6];
                    cube[4][7] = cube[2][7];
                    cube[4][8] = cube[2][8];

                    cube[2][6] = cube[5][6];
                    cube[2][7] = cube[5][7];
                    cube[2][8] = cube[5][8];

                    cube[5][6] = cube[3][6];
                    cube[5][7] = cube[3][7];
                    cube[5][8] = cube[3][8];

                    cube[3][6] = temp[0];
                    cube[3][7] = temp[1];
                    cube[3][8] = temp[2];
                }
                break;

            case 'F':
                rotateFace(2, direction);
                temp = new String[]{cube[0][6], cube[0][7], cube[0][8]};
                if(direction == '+') {
                    cube[0][6] = cube[4][8];
                    cube[0][7] = cube[4][5];
                    cube[0][8] = cube[4][2];

                    cube[4][2] = cube[1][0];
                    cube[4][5] = cube[1][1];
                    cube[4][8] = cube[1][2];

                    cube[1][0] = cube[5][6];
                    cube[1][1] = cube[5][3];
                    cube[1][2] = cube[5][0];

                    cube[5][0] = temp[2];
                    cube[5][3] = temp[1];
                    cube[5][6] = temp[0];
                } else {
                    cube[0][6] = cube[5][0];
                    cube[0][7] = cube[5][3];
                    cube[0][8] = cube[5][6];

                    cube[5][0] = cube[1][2];
                    cube[5][3] = cube[1][1];
                    cube[5][6] = cube[1][0];

                    cube[1][0] = cube[4][2];
                    cube[1][1] = cube[4][5];
                    cube[1][2] = cube[4][8];

                    cube[4][2] = temp[0];
                    cube[4][5] = temp[1];
                    cube[4][8] = temp[2];
                }
                break;

            case 'B':
                rotateFace(3, direction);
                temp = new String[]{cube[0][0], cube[0][1], cube[0][2]};
                if(direction == '+') {
                    cube[0][0] = cube[5][2];
                    cube[0][1] = cube[5][5];
                    cube[0][2] = cube[5][8];

                    cube[5][2] = cube[1][8];
                    cube[5][5] = cube[1][7];
                    cube[5][8] = cube[1][6];

                    cube[1][6] = cube[4][0];
                    cube[1][7] = cube[4][3];
                    cube[1][8] = cube[4][6];

                    cube[4][0] = temp[2];
                    cube[4][3] = temp[1];
                    cube[4][6] = temp[0];
                } else {
                    cube[0][0] = cube[4][6];
                    cube[0][1] = cube[4][3];
                    cube[0][2] = cube[4][0];

                    cube[4][0] = cube[1][6];
                    cube[4][3] = cube[1][7];
                    cube[4][6] = cube[1][8];

                    cube[1][6] = cube[5][8];
                    cube[1][7] = cube[5][5];
                    cube[1][8] = cube[5][2];

                    cube[5][2] = temp[0];
                    cube[5][5] = temp[1];
                    cube[5][8] = temp[2];
                }
                break;

            case 'L':
                rotateFace(4, direction);
                temp = new String[]{cube[0][0], cube[0][3], cube[0][6]};
                if(direction == '+') {
                    cube[0][0] = cube[3][8];
                    cube[0][3] = cube[3][5];
                    cube[0][6] = cube[3][2];

                    cube[3][2] = cube[1][6];
                    cube[3][5] = cube[1][3];
                    cube[3][8] = cube[1][0];

                    cube[1][0] = cube[2][0];
                    cube[1][3] = cube[2][3];
                    cube[1][6] = cube[2][6];

                    cube[2][0] = temp[0];
                    cube[2][3] = temp[1];
                    cube[2][6] = temp[2];
                } else {
                    cube[0][0] = cube[2][0];
                    cube[0][3] = cube[2][3];
                    cube[0][6] = cube[2][6];

                    cube[2][0] = cube[1][0];
                    cube[2][3] = cube[1][3];
                    cube[2][6] = cube[1][6];

                    cube[1][0] = cube[3][8];
                    cube[1][3] = cube[3][5];
                    cube[1][6] = cube[3][2];

                    cube[3][2] = temp[2];
                    cube[3][5] = temp[1];
                    cube[3][8] = temp[0];
                }
                break;

            case 'R':
                rotateFace(5, direction);
                temp = new String[]{cube[0][2], cube[0][5], cube[0][8]};
                if(direction == '+') {
                    cube[0][2] = cube[2][2];
                    cube[0][5] = cube[2][5];
                    cube[0][8] = cube[2][8];

                    cube[2][2] = cube[1][2];
                    cube[2][5] = cube[1][5];
                    cube[2][8] = cube[1][8];

                    cube[1][2] = cube[3][6];
                    cube[1][5] = cube[3][3];
                    cube[1][8] = cube[3][0];

                    cube[3][0] = temp[2];
                    cube[3][3] = temp[1];
                    cube[3][6] = temp[0];
                } else {
                    cube[0][2] = cube[3][0];
                    cube[0][5] = cube[3][3];
                    cube[0][8] = cube[3][6];

                    cube[3][0] = cube[1][8];
                    cube[3][3] = cube[1][5];
                    cube[3][6] = cube[1][2];

                    cube[1][2] = cube[2][2];
                    cube[1][5] = cube[2][5];
                    cube[1][8] = cube[2][8];

                    cube[2][2] = temp[0];
                    cube[2][5] = temp[1];
                    cube[2][8] = temp[2];
                }
                break;
        }
    }

    public static class Move{
        char side;
        char direction;

        Move(char side, char direction){
            this.side = side;
            this.direction = direction;
        }

    }
}
