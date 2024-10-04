package Backjoon_level;
import java.util.*;
import java.io.*;
public class problem_2292 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int a=0;
        int b=1;
        while(N!=1){
            if(2+6*(a) <= N && N<= 1+6*(b)) {
                answer++;
                break;
            }
            answer++;
            a+=answer;
            b+=answer+1;
        }
        answer++;
        System.out.println(answer);
        // 1
        // 2~7 0 6x0+2 ~ 6x1+1
        // 8~19 1 6x1+2 ~ 6x3+1
        // 20~37 2 6x3+2 ~ 6x6+1
        // 38~61 3 6x6+2 ~ 6x10+1
        // 62~91 4 6x10+2 ~ 6x15+1
        // 6n 12n
    }
}
