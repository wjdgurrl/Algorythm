package programmers_level0;

import java.util.ArrayList;
import java.util.Locale;

public class course_181913 {
    public static void main(String[] args) {
        course_181913 aa = new course_181913();
        System.out.println(aa.solution("rermgorpsam",new int[][]{{2, 3}, {0, 7}, {5, 9}, {6, 10}}));
    }
    public String solution(String my_string, int[][] queries) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add(my_string);
        String answer = "";

        for(int i=0;i<queries.length;i++){
            String front = arr.get(i).substring(0,queries[i][0]);
            String end = arr.get(i).substring(queries[i][1]+1,arr.get(i).length());
            String change = "";
            for(int j = queries[i][1];j>=queries[i][0];j--){
                change += arr.get(i).substring(j,j+1);
            }
            arr.add(front+change+end);
        }

        answer = arr.get(arr.size()-1);
        return answer;
    }
}
