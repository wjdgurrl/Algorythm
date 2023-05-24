package programmers_level0;

public class course_120866 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 0, 0, 0, 0},{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}}));
        System.out.println(solution(new int[][]{{1}}));
    }
    public static int solution(int[][] board){
        int answer = 0;
        int[] dy = new int[]{-1,-1,-1,0,0,1,1,1};
        int[] dx = new int[]{-1,0,1,-1,1,-1,0,1};

        if(board.length == 1){
            answer = board[0][0] ==1?0:1;
            return answer;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1){
                    for (int k = 0; k < 8; k++) {
                        int y = dy[k];
                        int x = dx[k];
                        if(i+y >=0 && j+x >=0 && i+y < board.length && j+x < board.length && board[i+y][j+x] != 1 ) board[i+y][j+x] = 2;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) answer++;
            }
        }
        return answer;
    }
}
