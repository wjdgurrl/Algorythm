package study.string;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/10809
public class problem_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] alp = new int[26];
        for (int i = 0; i < 26; i++) alp[i] = -1;
        String line = br.readLine();

        for (int i = 0; i < line.length(); i++) {
            for (int j = 97; j < 123; j++) {
                char c = line.charAt(i);

                if((c) == j && alp[j-97] == -1) {
                    alp[j-97] = i;
                }

            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(alp[i]).append(" ");
        }
        System.out.println(sb.toString().trim());

        br.close();
        bw.close();
    }
}
