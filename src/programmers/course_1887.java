package programmers;

import java.util.Arrays;

public class course_1887 {
    public static void main(String[] args) {
        System.out.println((aaa(new String[]{"EEEEE", "EEMEE", "EEEEE", "EEEEE"}, 2, 0)));
    }
    static final int[] dy = {1,1,0,-1,-1,-1,0,1};
    static final int[] dx = {0,1,1,1,0,-1,-1,-1};
    static final int[] around = {0,0,0,0,0,0,0,0};
    public static String[] aaa(String[] board, int y, int x){
        String[] answer = {};
        int around_check=0;
        char select = (board[y].charAt(x));
        if(select == 'M');
        else{
            for (int i = 0; i < 8; i++) {
                if((board[y+dy[i]].charAt(x+dx[i])=='M')){
                    around[i] = 1;
                    around_check++;
                }
            }
            if (around_check == 8) {

            }

        }
        return answer;
    }
}
