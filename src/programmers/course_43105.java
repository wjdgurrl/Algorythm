package programmers;
import java.util.*;
import java.io.*;

public class course_43105 {
    private int[][] sum;
    public static void main(String[] args) {
        course_43105 aa = new course_43105();
        System.out.println(aa.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
    public int solution(int[][] triangle){
        int answer = 0;
        for (int i = triangle.length-1; i > 0; i--) {
            for (int j = 0; j < triangle[i].length-1; j++) {
                triangle[i-1][j] += Math.max(triangle[i][j], triangle[i][j+1]);
            }
        }
        answer = triangle[0][0];
        return answer;
    }
    
}
