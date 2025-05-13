package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/13335
public class problem_13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken()); // 다리길이
        int L = Integer.parseInt(st.nextToken()); // 하중
        int[] trucks = new int[n];
        ArrayDeque<Integer> bridge = new ArrayDeque<>(w);
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < w; i++) {
            bridge.offerLast(0);
        }

        int onBridgeWeight = 0; //다리 위 총 무게
        int time = 0;
        int index = 0;

        while(index < n){
            time++;

            // 맨 앞 트럭 내리기
            onBridgeWeight -= bridge.pollFirst();

            //트럭 올리기
            if(onBridgeWeight + trucks[index] <= L){
                int truckWeight = trucks[index];
                bridge.offerLast(truckWeight);
                onBridgeWeight += truckWeight;
                index++;
            }else{
                //트럭 안올라가면
                bridge.offerLast(0);
            }
        }
        time += w;

        System.out.println(time);


    }

}
