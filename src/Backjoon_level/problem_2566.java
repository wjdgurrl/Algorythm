package Backjoon_level;
import java.io.*;
import java.util.*;
public class problem_2566 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[9][9];
        int[] MAX = new int[3];
        MAX[0] = -1;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken(" "));
                if(MAX[0] < arr[i][j]){
                    MAX[0] = arr[i][j];
                    MAX[1] = i+1;
                    MAX[2] = j+1;
                }
            }
        }
        System.out.println(MAX[0]+"\n"+MAX[1]+" "+MAX[2]);
    }
}
