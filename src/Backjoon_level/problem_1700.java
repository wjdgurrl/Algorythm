package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/1700
public class problem_1700 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);
        int[] electrics = readInput(br,K);
        //1000000
        solve(electrics, N);
    }

    //배열 돌아서 안쓰는거 뽑아야 함
    public static void solve(int[] electrics, int N){
        ArrayList<Integer> arr = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < electrics.length; i++) {
            int cur = electrics[i];

            if(arr.contains(cur)) continue;
            if(arr.size() < N){
                arr.add(cur);
                continue;
            }
            //뽑기
            int deleteIndex = -1;
            int lastIndex = -1;

            for (int j = 0; j < arr.size(); j++) {
               int plug = arr.get(j);

               int nextUse = 102; //인덱
               for (int k = i+1; k < electrics.length; k++ ) {
                   if(electrics[k] == plug){
                       nextUse = k;
                       break;
                   }
               }



               if(nextUse > lastIndex){
                   lastIndex = nextUse;
                   deleteIndex = j; //기존꺼 빼야 함
               }
            }
            arr.remove(deleteIndex);
            arr.add(cur);
            count++;

        }
        System.out.println(count);
    }

    public static int[] readInput(BufferedReader br, int K) throws IOException {
        int[] arr = new int[K];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        return arr;
    }
}
