package Backjoon_level;
import java.io.*;
import java.util.*;

public class problem_2884 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String time = br.readLine();
        StringTokenizer st = new StringTokenizer(time);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int H  = (Integer.parseInt(st.nextToken())) * 60;
        int M =  Integer.parseInt(st.nextToken());

        if((M+H) - 45 >= 0){
            int hour = ((M+H) - 45) / 60;
            int minute = ((M+H) -45) - (hour*60);
            bw.write(hour +" "+ minute);
        }
        else if((M+H) - 45 < 0){
            int hour = (60*24 - M) / 60;
            int minute = 60 + (M-45);
            if(hour == 24 && minute >= 15){
                hour -=1;
            }

            bw.write(hour +" "+ minute);
        }
        bw.flush();
    }
}
