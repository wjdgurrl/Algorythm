package Backjoon_level;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double[] arr = new double[Integer.parseInt(br.readLine())];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int j = 0;
        while(st.hasMoreTokens()){
            arr[j++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        double highScore = arr[arr.length-1];
        double avg = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / highScore*100;
            avg += arr[i];
        }
        System.out.println(avg / arr.length);

    }
}
