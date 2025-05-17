package study.GREEDY;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/1439
public class problem_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("");
        String start = s[0];
        int count = 0;
        int temp = 0;
        for (String a : s) {
            if(!a.equals(start)){
                temp++;
            }else{
                if(temp > 0){
                    count++;
                }
                temp = 0;
            }
        }
        if(temp > 0){
            count++;
        }
        System.out.println(count);
    }
}
