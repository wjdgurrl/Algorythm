package Backjoon_level;

import java.io.*;
import java.util.*;

public class problem_10818 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        //ArrayList<Integer> array = new ArrayList<>();
        String input = br.readLine();
        st = new StringTokenizer(input);
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        System.out.println(arr[0] + " " + arr[N - 1]);
    }
}
