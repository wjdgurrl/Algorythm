package Backjoon_level;

import java.util.*;
import java.io.*;

public class problem_1744 {
    static ArrayList<Integer> Arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        boolean zero = false;
        PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();
        for (int i = 0; i < num; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input < 0) {
                negative.add(input);
            } else if (input > 0) {
                positive.add(input);
            } else {
                zero = true;
            }
        }

        System.out.println(solution(positive,negative,zero));
        br.close();
    }
    static public int solution(PriorityQueue<Integer> positive, PriorityQueue<Integer> negative, boolean zero){
        int answer = 0;
        while(!positive.isEmpty()){
            Integer first = positive.poll();
            Integer second = positive.poll();
            if(second == null){
                answer += first;
                break;
            }
            if(second == 1){
                answer += first + second;
                continue;
            }
            answer += first * second;
        }
        while(!negative.isEmpty()){
            Integer first = negative.poll();
            Integer second = negative.poll();
            if(second == null){
                if(!zero) answer += first;
                break;
            }
            else{
                answer += first * second;
            }
        }
        return answer;
    }
}
