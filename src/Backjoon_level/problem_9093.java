package Backjoon_level;
import java.util.*;
import java.io.*;
public class problem_9093 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Stack<Character> stack;
        String answer = "";
        for (int i = 0; i < T; i++) {
            String[] words = br.readLine().split(" ");
            StringBuilder sb = new StringBuilder();
            for(String word : words){
                stack = new Stack<>();
                for(char c : word.toCharArray()){
                    stack.push(c);
                }
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(" ");
            }
            answer = sb.toString().trim();
            System.out.println(answer);
        }
        br.close();
    }
}
