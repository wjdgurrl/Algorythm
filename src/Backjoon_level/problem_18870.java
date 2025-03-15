package Backjoon_level;

import javax.lang.model.type.ArrayType;
import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/18870
public class problem_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());;
        }
        br.close();

        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0;

        for(int num : sorted) {
            if(!map.containsKey(num)) {
                map.put(num, rank++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : arr){
            sb.append(map.get(num)).append(" ");
        }
        System.out.println(sb.toString().trim());

    }
}
