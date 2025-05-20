package study.GREEDY;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/15903
public class problem_15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] cards = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            Arrays.sort(cards);
            long plusNum = plusCard(cards[0], cards[1]);
            cards[0] = plusNum;
            cards[1] = plusNum;
        }
        long sum = 0;
        for (long c : cards) {
            sum += c;
        }
        System.out.println(sum);
    }
    private static long plusCard(long firstCard, long secondCard) {
        return firstCard + secondCard;
    }
}
