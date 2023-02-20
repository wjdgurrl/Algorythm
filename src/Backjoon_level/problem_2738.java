package Backjoon_level;
import java.io.*;
import java.util.*;

public class problem_2738 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[2*M][N];
        for (int i = 0; i < 2*M; i++) {
            int j=0;
            String input = br.readLine();
            st = new StringTokenizer(input," ");
            while(st.hasMoreTokens()){
                arr[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }
        for (int i=0;i < M; i++){
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + arr[i+M][j]+" ");
                if(j == N-1){
                    System.out.println();
                }
            }
        }
        System.out.println(Arrays.deepToString(arr));
    }
}
