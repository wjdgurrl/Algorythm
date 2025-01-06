package study.RECURSION;

import java.io.*;

public class problem_1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long A = Integer.parseInt(input[0]);
        long B = Integer.parseInt(input[1]);
        long C = Integer.parseInt(input[2]);
        System.out.println(madPow(A, B, C));
    }
    public static long madPow(long a, long b, long c) {
        if(b == 1) return a % c; //basecase : 지수가 1일때
        long val = madPow(a,b/2,c); //지수를 반으로 줄여 재귀 호출
        val = (val * val) % c; // 결과를 제곱하고 연산
        if(b % 2 == 0) return val; //b가 짝수인 경우
        return (val * a) % c;//b가 홀수인 경우, 추가적으로 a를 곱하기
    }
}
