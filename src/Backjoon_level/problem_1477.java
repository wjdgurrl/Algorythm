package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/1477
public class problem_1477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 휴게소 개수
        int M = Integer.parseInt(input[1]); // 더 지으려는 휴게소 수
        int L = Integer.parseInt(input[2]); // 고속도로의 길이


        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> stations = new ArrayList<>();
        stations.add(0);
        for (int i = 0; i < N; i++) {
            stations.add(Integer.parseInt(st.nextToken()));
        }
        stations.add(L); // 휴게소 위치 넣기

        Collections.sort(stations);

        int low = 1;
        int high = L;

        while (low <= high) {
            int mid = (low + high) / 2; // 현재 간격
            int cnt = 0; //추가해야 하는 휴게소 개수
            for (int i = 1; i < stations.size(); i++) {
                int distance = stations.get(i) - stations.get(i-1);
                cnt += (distance / mid);
                if(distance % mid ==0) cnt --; //중복제거
            }

            //M개 이하면 간격 더 줄이기
            if(cnt <= M){
                answer = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        System.out.println(answer);

        //각 휴게소마다 길이 구하기?



        //다솜이는 이 고속도로를 이용할 때, 모든 휴게소를 방문한다.
        //다솜이는 휴게소를 M개 더 지어서 휴게소가 없는 구간의 길이의 최댓값을 최소로 하려고 한다. (반드시 M개를 모두 지어야 한다.)
    }
}
