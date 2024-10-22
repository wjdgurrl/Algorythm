package Backjoon_level;

import java.util.*;
import java.io.*;

public class problem_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = (br.readLine().split(" "));
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        Array arr = new Array();
        arr.Array();
        arr.setArr(N);
        System.out.println(arr.yoshepush(K));
        br.close();
    }
    private static class Array{
        private ArrayList<Integer> arr;
        private int index;
        private void Array(){
            this.arr = new ArrayList<>();
            this.index = 0;
        }
        private void setArr(int N){
            for (int i = 1; i <= N; i++) {
                this.arr.add(i);
            }
        }
        private StringBuilder yoshepush(int K){
            StringBuilder sb = new StringBuilder("<");
            while(arr.size() > 1){
                this.index = (this.index-1 + K) % this.arr.size();
                sb.append(this.arr.remove(index)).append(", ");
            }
            return sb.append(arr.get(0)).append(">");
        }
    }
}

