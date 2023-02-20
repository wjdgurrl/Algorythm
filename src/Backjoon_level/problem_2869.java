package Backjoon_level;

import java.io.*;
import java.util.*;
public class problem_2869 {
    public static void main(String[] args)throws IOException{
        long beforeTime = System.currentTimeMillis();
        long A,B,V; // A= 낮에 오를 미터 B= 자는동안 내려갈 미터 V= 높이
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input = br.readLine();
        st = new StringTokenizer(input);
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        long day = (V-A) / (A-B);  //마지막날
        if((V-A) % (A-B) == 0){
            System.out.println(day+1);
        }
        else{
            System.out.println(day+2);
        }

        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);
    }
}
