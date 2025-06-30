package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/8980
public class problem_8980 {

    public static ArrayList<boxInfo> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int C = Integer.parseInt(line[1]);
        int M = Integer.parseInt(br.readLine());

        list = new ArrayList<boxInfo>();
        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            list.add(new boxInfo(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2])));
        }

        list.sort(new Comparator<boxInfo>() {
            @Override
            public int compare(boxInfo o1, boxInfo o2) {
                if(o1.endIndex == o2.endIndex){
                    return o1.startIndex - o2.startIndex;
                }
                return  o1.endIndex - o2.endIndex;
            }
        });

        int[] storage =  new int[N + 1]; //각 마을별 잔여 용량
        for(int i = 1; i <= N; i++){
            storage[i] = C;
        }
        int answer = 0;

        for(boxInfo box : list){
            int minStorage = Integer.MAX_VALUE;

            //System.out.println(Arrays.toString(storage));

            //1 2, 1 3, 1 4
            for(int i = box.startIndex; i < box.endIndex; i++){
                minStorage = Math.min(minStorage, storage[i]);
            }

            //추가할거
            //minStorage보다 크면 다 못실음
            int addSize = Math.min(minStorage, box.size);
            answer += addSize;

            for (int i = box.startIndex; i < box.endIndex; i++){
                storage[i] -= addSize;
            }
        }

        System.out.println(answer);

    }

    public static class boxInfo{

        int startIndex;
        int endIndex;
        int size;

        boxInfo(int startIndex, int endIndex, int size){
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.size = size;
        }

    }
}
