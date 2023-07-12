package programmers_level0;
import java.util.*;
import java.io.*;
public class course_457 {
    static ArrayList<Integer> ar= new ArrayList<>();
    public static void main(String[] args) {
        course_457 a = new course_457();
        System.out.println(a.solution(12));
    }
    public int solution(int n){
        int answer = 0;
        for (int i = 1; i*i <= n; i++) {
            if(i * i == n) answer+= i;
            else if(n % i == 0){
                answer += i+ (n/i);
            }
        }
        return answer;
        }

}
