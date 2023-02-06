package Backjoon_level;

import java.util.*;
import java.io.*;

public class problem_1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = 0;
        int fir,sec;
        int i = Integer.parseInt(br.readLine());
        int check = i;
        while(true){
            fir = i /10;
            sec = i %10;
            i = sec*10 + (fir+sec)%10;
            count++;
            if(check == i){
                break;
            }
        }
        bw.write(String.valueOf(count));
        bw.close();
        br.close();
    }
}
