package study.RECURSION;

import java.util.*;
import java.io.*;

public class problem_1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 2**N x 2**N 박스\
        int r = Integer.parseInt(input[1]); //r행
        int c = Integer.parseInt(input[2]); //c열

        System.out.println(func(N,r,c));
        br.close();
        //1.함수 정의
        // 2**N x 2**N 배열에서 r,c 를 방문하는 순서를 반환 하는 함수
        //2.baseConditon
        // n=0일대 return 0;
        //3.재귀식
        // r,c가 1번 사각형 -> return func(n-1,r,c)
        //       2번 -> return 절반 x 절반 + func(n-1,r,c-절반)
        //       3번 -> return 2 * 절반 * 절반 + func(n-1,r-절반,c)
        //       4번 -> return 3 * 절반 * 절반 + func(n-1,r-절반,c-절반)
    }
    public static int func(int n, int r, int c){
        if(n == 0) return 0;
        int half = (int)Math.pow(2,n-1);

        if(r < half && c < half){
            return func(n-1, r,c);
        }
        if(r < half && c >= half){
            return half * half + func(n-1,r,c-half );
        }
        if(r >= half && c < half){
            return 2 * half * half + func(n-1,r-half,c);
        }
        return 3 * half * half + func(n-1,r-half,c-half);
    }
}
