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
        String[] input = s.split("");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            if(input[0].equals(")")){
                stack.push(input[0]);
                break;
            }
            if(!stack.isEmpty() && !(stack.peek().equals(input[i]))){
                stack.pop();
            }
            stack.push(input[i]);
        }
        answer = stack.isEmpty();
        return answer;
    }
}
