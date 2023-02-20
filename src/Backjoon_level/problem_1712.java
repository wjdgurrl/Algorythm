package Backjoon_level;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem_1712 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken()); // 고정비용
        long B = Integer.parseInt(st.nextToken()); // 가변비용(개수 곱)
        long C = Integer.parseInt(st.nextToken()); // 수익(개수 곱)
        int t = (C>B) ? (int) (C - B) : -1;
        double result = ((double) A / t);
        if (result > 0){
            System.out.println((int)result+1);
        }else{
            System.out.println(-1);
        }

    }
}
