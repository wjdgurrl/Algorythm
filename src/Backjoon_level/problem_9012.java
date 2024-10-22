package Backjoon_level;

import java.util.*;
import java.io.*;

public class problem_9012 {
    public static void main(String[] args) throws IOException {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        VpsChecker vps = new VpsChecker();
        int T = inputHandler.readTestCases();
        for(int i=0; i < T ; i++){
            outputHandler.printAnswer(vps.VpsCheck(inputHandler.readStringLine()));
        }
    }
}
class InputHandler{
    private BufferedReader br;
    public InputHandler(){
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }
    public int readTestCases()throws IOException{
        return Integer.parseInt(br.readLine());
    }
    public String readStringLine()throws IOException{
        return br.readLine();
    }
}
class VpsChecker{
    private Stack<Character> stack;
    private String answer;
    public String VpsCheck(String input){
        this.stack = new Stack<>();
        for(char c : input.toCharArray()){
            if(c == '(') this.stack.push(c);
            else{
                if(this.stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        return this.stack.isEmpty() ? "YES" : "NO";
    }
}
class OutputHandler{
    public void printAnswer(String answer){
        System.out.println(answer);
    }
}
