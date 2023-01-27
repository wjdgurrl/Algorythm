package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class course_1844 {
    public static void main(String[] args) {
        //distance.bfs();
    }

}

//start = 0,0
//end = length,length[]

class distance{
    public static int bfs(int[][] maps){
        int answer = 0;
        int col = maps.length;
        int row = maps[0].length;
        boolean[][] visit_map = new boolean[col][row];
        visit_map[0][0] = true; // start

        Queue<int[]> queue = new LinkedList<>();//node

        while(!queue.isEmpty()){
            int[] q = queue.poll();

            //if(visit_map[q[0]][1])






        }








        return answer;
    }
}

