package Backjoon_level;

import java.util.*;

public class problem_4673 {
    static ArrayList<Integer> d(int n) {
        int sum = 0;
        int num = 0;
        for (int i = 1; i <= n; i++) {
            Input.add(i);
            num = i;
            while(num != 0) {
                sum += (num % 10);
                num = num / 10;
            }
            Output.add(i+sum);
            sum = 0;
        }
        for (int t = 0; t < n; t++){
            if(Input.contains(Output.get(t))){
                Input.remove(Output.get(t));
            }
        }
        return Input;
    }
        static ArrayList<Integer> Input = new ArrayList<>();
        static ArrayList<Integer> Output = new ArrayList<>();
        public static void main (String[]args){
            d(10000);
            for (int q:Input) {
                System.out.println(q);
            }
        }
}
