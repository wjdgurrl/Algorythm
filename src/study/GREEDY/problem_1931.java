package study.GREEDY;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/1931
public class problem_1931 {

    public static ArrayList<time> times = new ArrayList<time>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // n개의 회의실 사용표

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            times.add(new time(Integer.parseInt(input[0]),Integer.parseInt(input[1])));
        }
        br.close();

        //끝나는 시간을 기준으로 정렬 해야 함
        Collections.sort(times,new TimeComparator());

        int count = 0;
        int lastEndTime = 0;

        for (time t : times){
            if(lastEndTime > t.start) continue; //시작 시간  < 종료 시간
            count++;
            lastEndTime = t.end;
        }

        System.out.println(count);
    }

    //Comparator 클래스를 별도로 생성하여 정렬
    public static class TimeComparator implements Comparator<time> {
        @Override
        public int compare(time a, time b) {
            if (a.end != b.end) return Integer.compare(a.end, b.end);
            return Integer.compare(a.start, b.start); // 종료 시간이 같으면 시작 시간 기준 정렬
        }
    }

    public static class time{
        int start;
        int end;

        time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
