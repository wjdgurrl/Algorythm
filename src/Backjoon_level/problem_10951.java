package Backjoon_level;

import java.io.*;
import java.util.*;

public class problem_10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while(true){
            String i = br.readLine();
            if(i == null || i.equals("")){ // EOF
                break;
            }
            st = new StringTokenizer(i);
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            bw.write(A+B+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
