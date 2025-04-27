package study.DP;

import java.util. *;
import java.io. *;

//https://www.acmicpc.net/problem/1912
public class problem_1912 {
    private static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] arr = readInput(br);
        long[] dp = new long[(n*(n+1)) / 2];

        for(int i=0; i < n; i++){
            dp[i] = arr[i];
        }
        if(n > 1){
            for (int i = n; i < dp.length; i++) {
                dp[i] = dp[i-n] + dp[i-n+1];
            }
        }

        System.out.println(Arrays.toString(dp));

    }

    private static long findMax(long[] arr){
        long max = Long.MIN_VALUE;
        for(long l : arr){
            if(max < l){
                max = l;
            }
        }
        return max;
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
