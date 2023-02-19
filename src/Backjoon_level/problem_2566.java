package Backjoon_level;
import java.io.*;
import java.util.*;
public class problem_2566 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken(" "));
            }
        }
        Arrays.sort(arr);
        System.out.println(Arrays.deepToString(arr));

    }
}
