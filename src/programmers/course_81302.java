package programmers;
import java.util.*;
import java.io.*;

public class course_81302 {
    public static void main(String[] args) {
        course_81302 aa = new course_81302();
        System.out.println(Arrays.toString(aa.solution(new String[][]{
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        })));
        //P는 응시자가 앉은 자리
        //O는 빈 테이블
        //X는 파티션
    }
    public int[] solution(String[][] places){
        int[] answer = {};
        for (int i = 0; i < places[0].length; i++) {
            for (int j = 0; j < places.length; j++) {
                String curSit = places[i][j];
                String[] P = curSit.split("");
               /* for (int k = 0; k < P; k++) {

                }*/
            }
            System.out.println();
        }
        return answer;
    }
}
