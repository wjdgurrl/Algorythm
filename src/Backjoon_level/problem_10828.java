package Backjoon_level;
import java.util.*;
import java.io.*;
public class problem_10828 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stackCommand sc = new stackCommand();
        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i < num; i++){
            String[] order = br.readLine().split(" ");
            switch (order[0]){
                case "push" :
                    sc.push(Integer.parseInt(order[1]));
                    break;
                case "pop" :
                    System.out.println(sc.pop());
                    break;
                case "top" :
                    System.out.println(sc.peek());
                    break;
                case "size" :
                    System.out.println(sc.size());
                    break;
                case "empty" :
                    System.out.println(sc.empty());
                    break;
            }

        }



    }
    private static class stackCommand{
        private Stack<Integer> stack;

        private stackCommand(){
            this.stack = new Stack<>();
        }
        private void push(int t){
            this.stack.push(t);
        }
        private int pop(){
            if(this.stack.isEmpty()){
                return -1;
            }
            return this.stack.pop();
        }
        private int peek(){
            if(this.stack.isEmpty()){
                return -1;
            }
            return this.stack.peek();
        }
        private int size(){
            return this.stack.size();
        }
        private int empty(){
            if(this.stack.isEmpty()){
                return 1;
            }
            return 0;
        }
    }
}
