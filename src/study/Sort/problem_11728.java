package study.Sort;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/11728
public class problem_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int S = Integer.parseInt(input[0]);
        int T = Integer.parseInt(input[1]);

        String[] a_input = br.readLine().split(" ");
        String[] b_input = br.readLine().split(" ");

        int[] A = fillArray(S, a_input);
        int[] B = fillArray(T, b_input);

        int[] result = mergeSort(A, B);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length - 1; i++) {
            sb.append(result[i]).append(" ");
        }
        sb.append(result[result.length - 1]);
        System.out.print(sb);


    }

    public static int[] mergeSort(int[] A, int[] B) {
        int[] result = new int[A.length + B.length];
        int aidx = 0, bidx = 0;
        for (int i = 0; i < A.length + B.length; i++) {
            if(aidx == A.length) result[i] = B[bidx++];
            else if(bidx == B.length) result[i] = A[aidx++];
            else if(A[aidx] > B[bidx]) {
                result[i] = B[bidx++];
            }
            else if(A[aidx] <= B[bidx]) {
                result[i] = A[aidx++];
            }
        }
        return result;
    }


    public static int[] fillArray(int n,String[] input){
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        return numbers;
    }
}
