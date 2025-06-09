package study.string;

import java.util.*;
import java.io.*;

public class problem_2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] line = br.readLine().split(" ");
            int R = Integer.parseInt(line[0]);
            String[] s = line[1].split("");

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length; j++) {
                for (int k = 0; k < R; k++) {
                    sb.append(s[j]);
                }
            }
            System.out.println(sb.toString());

        }
        br.close();
    }
}
