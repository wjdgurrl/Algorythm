package Backjoon_level;
import java.io.*;
import java.util.*;

public class problem_4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Double> result = new ArrayList<>();
        int C = Integer.parseInt(br.readLine());
        int sum = 0;
        int count=0;
        int temp = 0;
        String score;
        for (int i = 0; i < C; i++) {
           score = br.readLine();
           st = new StringTokenizer(score);
           int N = Integer.parseInt(st.nextToken());

           for (int j = temp; j < temp+N; j++) {
               arr.add(Integer.parseInt(st.nextToken()));
               sum += (arr.get(j));
           }
            for (int j = temp; j < temp+N; j++) {
                if((arr.get(j)) > (sum / N)){
                    count++;
                }
            }
            result.add(100*((double) count)/N);
            temp += N;
            sum = 0;
            count = 0;
        }
        br.close();
        for (int i = 0; i < C; i++) {
            System.out.println(String.format("%.3f",result.get(i))+"%");
        }
    }
}
