package programmers;
import java.util.Stack;
import java.io.*;

public class course_12909 {
    public static void main(String[] args) {
        boolean answer = stackCheck(new String("()()"));
        System.out.println(answer);
    }
    public static boolean stackCheck(String s){
        boolean answer = false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '('){
                stack.push(ch);
            }else if(ch == ')'){
                if(stack.isEmpty()){
                    return answer;
                }
                stack.pop();
            }
        }
        answer = stack.isEmpty();
        return answer;
    }
}
