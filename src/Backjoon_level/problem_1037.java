package Backjoon_level;

import java.io.*;
import java.util.*;

public class problem_1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int i  = 0;
        while(st.hasMoreTokens()){
            arr[i++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        if(arr.length != 1){
            System.out.println(arr[0] * arr[arr.length-1]);
        }else{
            System.out.println(arr[0] * arr[0]);
        }
    }
}
