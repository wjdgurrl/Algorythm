package study.GREEDY;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/1541
public class problem_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr= new ArrayList<>();
        boolean minus = false;
        readInput(br,arr);
        int answer = 0;
        answer += arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if(minus || arr.get(i) < 0){
                minus = true;
                int temp = Math.abs(arr.get(i));
                answer -= temp;
            }else{
                answer += arr.get(i);
            }
        }
        System.out.println(answer);
    }
    private static void readInput(BufferedReader br, ArrayList<Integer> arr) throws IOException {
        StringBuilder sb = new StringBuilder();
        String[] line = br.readLine().split("");
        for (String s : line) {
            if(s.equals("+") || s.equals("-")){
                arr.add(Integer.parseInt(sb.toString()));
                sb = new StringBuilder();
            }
            sb.append(s);
        }
        arr.add(Integer.parseInt(sb.toString()));
    }
}
