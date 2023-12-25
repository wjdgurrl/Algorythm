package programmers;

public class course_250134 {
    static int[][] maze = new int[][]{{1,4},{0,0},{2,3}};
    //        [[1, 4],
    //         [0, 0],
    //         [2, 3]]
    public static void main(String[] args) {

    }
    public boolean check(int x, int y){
        return x < 0 || y < 0 || x >= maze[0].length || y >= maze.length;
    }
    public void move(){
        //도착
        //if()
    }
    public int solution(int[][] maze){
        int answer = 0;
        int[] dx = new int[]{1,0,-1,0};
        int[] dy = new int[]{0,1,0,-1};
        int[] redStart = new int[2];
        int[] redEnd = new int[2];
        int[] blueStart = new int[2];
        int[] blueEnd = new int[2];
        //      1        3       2         4

        boolean[][] redVisted = new boolean[maze.length][maze[0].length];
        boolean[][] blueVisted = new boolean[maze.length][maze[0].length];

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 1) {
                    redStart = new int[]{i,j}; //0,0
                }
                if (maze[i][j] == 2) {
                    blueStart = new int[]{i,j}; // 2,0
                }
                if (maze[i][j] == 3){
                    redEnd = new int[]{i,j}; //2,1
                }
                if (maze[i][j] == 4){
                    blueEnd = new int[]{i,j}; // 0,1
                }
            }
        }
        redVisted[redStart[0]][redStart[1]] = true;
        blueVisted[blueStart[0]][blueStart[1]] = true;
        //todo 범위체크
        return answer;
    }
}
