package study;
import java.util.*;
public class pow {
    public static void main(String[] args) {
        pow aa = new pow();
        System.out.println(aa.solution("18446744073709551615","287346502836570928366"));
    }
    public String solution(String a, String b) {
        String answer = "";
        Long aa = Long.parseLong(a);
        Long bb = Long.parseLong(b);
        answer = String.valueOf(aa+bb);
        return answer;
    }
}
