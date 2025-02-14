package Backjoon_level;

import java.util. *;
import java.io. *;

public class problem_12100 {
    private static int N;
    private static int[][] board;
    private static int max = Integer.MIN_VALUE;


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

        dfs(0,board);

        System.out.println(max);
    }

    public static int findMax(int[][] board){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(board[i][j], max);
            }
        }
        return max;
    }

    public static void dfs(int depth, int[][] board){
        if(depth == 5){
            //최고 스코어 계산
            //최고 스코어 Math.max
            max = Math.max(max, findMax(board));
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] copied_board = Arrays.copyOf(board,N); // 원본 보드 복사

            for (int j = 0; j < i; j++) { // i번 회전
                copied_board = rotate(copied_board);
            }

            int[][] moved_board = moveLeft(copied_board); // moved_board 지역 변수로 사용
            dfs(depth + 1, moved_board);
        }
    }

    //왼쪽으로 밀어버리기
    public static int[][] moveLeft(int[][] board){
        int[][] moved_board = new int[N][N];
        for (int i = 0; i < N; i++) {

            int[] line = new int[N]; //한줄 복사
            int idx = 0; //삽입 위치 인덱스
            int lastValue = 0; //마지막으로 넣은 숫자

            for (int j = 0; j < N; j++) {
                if(board[i][j] == 0) continue; //맨 왼쪽 스킵
                // board [0][2][2]
                //        i
                if(lastValue == 0){ // 삽입 위치 비워짐
                    lastValue = board[i][j];
                }
                //[2][ ][2]
                // i
                //[2][ ][ ]
                //[ ][2][2]
                //[4][ ][ ]
                // i
                //    i
                else if(lastValue == board[i][j]){ //합쳐져야 할때
                    line[idx] = lastValue * 2;
                    lastValue = 0;
                    idx++;
                }
                //[2][ ][4]
                // i     j
                //[2][4][ ]
                //    i
                else{ //그냥 다른 값 만날때
                    //line[idx] != board[i][j]
                    line[idx] = lastValue;
                    lastValue = board[i][j];
                    idx++;
                }
            }
            if(lastValue != 0){
                line[idx] = lastValue; // 마지막 값 넣기
            }

            moved_board[i] = line;
        }
        return moved_board;
    }

    public static int[][] rotate(int[][] board){
        int[][] rotated_board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rotated_board[i][j] = board[N-1-j][i];
            }
        }
        return rotated_board;

    }
}
