package Backjoon_level;

import java.io.*;
import java.util.*;

public class problem_2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String current_time = br.readLine();
        StringTokenizer st = new StringTokenizer(current_time);
        int A = Integer.parseInt(st.nextToken()) * 60; // 시 -> 분
        int C = Integer.parseInt(st.nextToken()); // 분
        int require_time = Integer.parseInt(br.readLine()); // 분 단위로 1000까지
        int AA,CC;
        if(((A+C) + require_time)/60 < 24){
           AA = ((A+C) + require_time) / 60;
           CC = ((A+C) + require_time) - AA*60;
        }
        else{
            AA = 24 - (((A+C)+require_time) / 60) ;
            CC = ((A+C)+require_time) % 60;
            if(AA < 0){
                AA = ((((A + C) + require_time)) / 60) - 24;
            }
        }
        bw.write(AA+" "+CC);
        bw.flush();
    }
}
