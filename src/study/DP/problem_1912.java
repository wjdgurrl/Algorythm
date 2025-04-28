package study.DP;

import java.util. *;
import java.io. *;

//https://www.acmicpc.net/problem/1912
public class problem_1912 {
    private static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] arr = readInput(br);

        long currentSum = arr[0]; //연속 합, 시작은 처음꺼
        long maxSum = arr[0]; //연속 합중 최대만 구하기

        for (int i = 1; i < n; i++) {
            currentSum = Math.max(arr[i], currentSum+arr[i]); // 현재까지 연속합을 이어갈지, 새로 시작할지
            maxSum = Math.max(maxSum, currentSum);
        }
        System.out.println(maxSum);

    }


    private static long[] readInput(BufferedReader br)throws IOException{
        n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        long[] arr = new long[n];

        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(line[i]);
        }
        return arr;

    }
}
