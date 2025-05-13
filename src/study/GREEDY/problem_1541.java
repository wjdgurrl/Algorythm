package study.GREEDY;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/1541
public class problem_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr= new ArrayList<>();
        readInput(br,arr);
        int answer = 0;
        boolean open = false;
        int minus= 0;

        for(int i=0;i<arr.size();i++){
            //괄호 열기
            if(arr.get(i) < 0 && !open){
                minus += arr.get(i);
                open = true;
            }
            //괄호 닫기
            else if(open && arr.get(i) < 0){
                answer += minus;
                open = false;
            }
            else if((arr.get(i) > 0) && !open){
                answer += arr.get(i);
            }else{
                minus -= arr.get(i);
            }

        }
        System.out.println(answer + minus);

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
