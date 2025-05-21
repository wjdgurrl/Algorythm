package study.GREEDY;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/2170
public class problem_2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayList<Line> arr = new ArrayList<Line>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        arr.sort((a,b) -> (int) (a.x - b.x));

        long total = 0;
        long start = arr.get(0).x;
        long end = arr.get(0).y;

        for (int i = 1; i < N; i++) {

            Line cur = arr.get(i);
            //겹침
            if(arr.get(i).x <= end) {
                end = Math.max(end,cur.y);
            }
            //안겹침
            else{
                total += end - start;
                start = cur.x;
                end = cur.y;
            }
        }
        total += end - start; //마지막
        System.out.println(total);
    }

    private static class Line{
        long x;
        long y;

        Line(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
}
