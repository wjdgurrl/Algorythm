package study.GREEDY;

import java.util. *;
import java.io. *;

//https://www.acmicpc.net/problem/2457
public class problem_2457 {

    private static int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Flower> flowerDate = new ArrayList<Flower>();
        int n = Integer.parseInt(br.readLine());
        int[][] flowers = new int[n][4];
        int count = 0;
        int cur = 60;


        // 3/1 ~ 11/30 최소 한가지 이상이 피어있도록 하기
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            flowers[i][0] = Integer.parseInt(input[0]);
            flowers[i][1] = Integer.parseInt(input[1]);
            flowers[i][2] = Integer.parseInt(input[2]);
            flowers[i][3] = Integer.parseInt(input[3]);
        }

        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = 0;
            for (int j = 0; j < flowers[i][0]; j++) start += month[j];
            start += flowers[i][1];
            for (int j = 0; j < flowers[i][2]; j++) end += month[j];
            end += flowers[i][3];
            if (end <= 60 || start > 334) continue;
            flowerDate.add(new Flower(start, end));
        }
        flowerDate.sort((f1, f2) -> {
            if (f1.start != f2.start) return f1.start - f2.start;
            return f2.end - f1.end;
        });
        int index = 0;
        while(cur <= 334){
            boolean found = false;
            int maxEnd = cur;
            while(index < flowerDate.size() && flowerDate.get(index).start <= cur){
                if (flowerDate.get(index).end > maxEnd) {
                    maxEnd = flowerDate.get(index).end;
                    found = true;
                }
                index++;
            }
            if(!found){
                count = 0;
                break;
            }
            cur = maxEnd;
            count++;

        }
        System.out.println(count);

        //4, 6, 9, 11 = 30
        // 1, 3, 5, 7, 8, 10, 12 = 31
        // 2 = 28
        //[시작일, 종료일]
        // 1. 제일 먼저 피는 꽃 찾기
        // 2. 60 ~ 334 사이에 있어야 함
        // 3. 그 다음으로 빠르게 끝나는 꽃 다시 찾기
    }

    private static class Flower{
        private int start;
        private int end;

        public Flower(int start, int end){
            this.start = start;
            this.end = end;
        }

    }
}
