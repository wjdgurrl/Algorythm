package programmers;
import java.util.*;
public class course_12930 {
    public static void main(String[] args) {
        course_12930 aa = new course_12930();
        System.out.println(aa.solution("try hello world"));
    }
    public String solution(String s) {
        String answer = "";
        s = s.toUpperCase();
        StringTokenizer st = new StringTokenizer(s," ");
        while(st.hasMoreTokens()){
            String word = st.nextToken();
            char[] target = word.toCharArray();
            for(int i = 1; i<target.length;i+=2){
                //String t = word.charAt(i);

            }
            answer += " "+word;
        }
        return answer;
    }
}
