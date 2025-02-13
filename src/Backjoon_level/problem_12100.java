package Backjoon_level;

import java.util. *;
import java.io. *;

public class problem_12100 {
    private static int N;
    private static int[][] board;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];


        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        System.out.println(Arrays.deepToString(board));
        System.out.println(Arrays.deepToString(moveLeft(board)));
    }

    public static void dfs(int depth, int[][] board){
        if(depth == 5){
            //최고 스코어 계산
            //최고 스코어 Math.max
            return;
        }
        int[][] copied_board = board.clone();
        for (int i = 0; i < 4; i++) {

        }

    }

    //왼쪽으로 밀어버리기
    public static int[][] moveLeft(int[][] board){
        int[][] moved_board = new int[N][N];
        for (int i = 0; i < N; i++) {
            int[] line = new int[N]; //한줄 복사
            int idx = 0; //삽입 위치 인덱스
            for (int j = 0; j < N; j++) {
                if(j == 0) continue; //맨 왼쪽 스킵
                //[ ][2][2]
                // i
                if(line[idx] == 0){ // 삽입 위치 비워짐
                    line[idx] = board[i][j];
                }
                //[2][ ][2]
                // i
                //[2][ ][ ]
                //[ ][2][2]
                //[4][ ][ ]
                // i
                //    i
                else if(line[idx] == board[i][j]){ //합쳐져야 할때
                    line[idx] = board[i][j] * 2;
                    idx++;
                }
                //[2][ ][4]
                // i     j
                //[2][4][ ]
                //    i
                else{ //그냥 다른 값 만날때
                    //line[idx] != board[i][j]
                    idx++;
                    line[idx] = board[i][j];
                }
            }
            moved_board[i] = line;
        }
        return moved_board;
    }
}
