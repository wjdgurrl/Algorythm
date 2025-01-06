package study.RECURSION;

import java.io.*;

public class problem_11729 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());// 원판 개수
        System.out.println((1 << n) - 1);
        hanoi(1,3,n);
        System.out.print(sb.toString());
        br.close();

    }
    public static void hanoi(int start, int end, int n){
        if(n == 1){//원판이 1개일 경우
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }

        //1. n-1개의 원판을 보조 기둥으로 이동
        hanoi(start,6-start-end,n-1);
        //2. 가장 큰 원판을 목표 기둥으로 이동
        sb.append(start).append(" ").append(end).append("\n");
        //3. n-1개의 원판을 보조 기둥에서 목표 기둥으로 이동
        hanoi(6-start-end, end ,n-1);
    }
}
