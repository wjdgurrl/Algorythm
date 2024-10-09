package Backjoon_level;
import java.util.*;
import java.io.*;
public class problem_10828 {
    public static void main(String[] args) throws IOException{
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String order = br.readLine();
            int emptyTrue = 0;
            if(order.equals("top")) stack.peek();
            if(order.equals("size")) System.out.println(stack.size());
            if(order.equals("empty")) {
                emptyTrue = stack.isEmpty()?1:0;
                System.out.println(emptyTrue);
            }
            if(order.equals("pop")) stack.pop();
            else stack.push(Integer.parseInt(order.substring(5,6)));
        }
    }
    private static class orderMenu{
        private String order;

        orderMenu(String order){
            this.order = order;
        }
        private orderMenu topOrder(){

        }
    }
}
