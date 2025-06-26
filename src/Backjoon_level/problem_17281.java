package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/17281
public class problem_17281 {
    private static HashMap<Integer, ArrayList<Integer>> playerRecord; //이닝별 선수 결과
    private static int N;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        playerRecord = new HashMap<>();
        fillPlayerRecord(br);
        //완전탐색
        /*for (int i=0; i < 9; i++){
            System.out.print("i = " + i + " ");
            System.out.println(playerRecord.get(i));
        }*/
        makeOrder(new boolean[9], new ArrayList<>());
        System.out.println(answer);


    }

    public static void makeOrder(boolean[] visited, ArrayList<Integer> order){
        if(order.size() == 8){
            ArrayList<Integer> fullOrder = new ArrayList<>(order);
            fullOrder.add(3,0);
            //게임 돌리기
            playBall(fullOrder);
            return;
        }

        for (int i = 1; i < 9; i++) {
            if(!visited[i]){

                visited[i] = true;
                order.add(i);

                makeOrder(visited, order);

                order.remove(order.size() - 1);
                visited[i] = false;

            }
        }
    }

    public static void playBall(ArrayList<Integer> order){
        //게임 전체, 선수 순서
        int score = 0;
        int current = 0;

        for (int i = 0; i < N; i++) {
            //각 이닝
            int outCount = 0;
            boolean[] bases = new boolean[3];

            while(outCount < 3){
                int batIndex = order.get(current);
                int result = playerRecord.get(batIndex).get(i);

                if(result == 0){
                    outCount++;
                }else if(result == 1){ // 1루타
                    if(bases[2]) score++;
                    bases[2] = bases[1];
                    bases[1] = bases[0];
                    bases[0] = true;
                }else if(result == 2){ // 2루타
                    if(bases[2]) score++;
                    if(bases[1]) score++;
                    bases[2] = bases[0];
                    bases[1] = true;
                    bases[0] = false;
                }else if(result == 3){ //3루
                    if(bases[2]) score++;
                    if(bases[1]) score++;
                    if(bases[0]) score++;
                    bases[2] = true;
                    bases[1] = false;
                    bases[0] = false;
                }else{ //홈런
                    for (int j = 0; j < 3; j++) {
                        if(bases[j]) score++;
                        bases[j] = false;
                    }
                    score++; //본인
                }

                current = (current + 1) % 9;
            }

        }
        answer = Math.max(answer, score);

    }

    public static void fillPlayerRecord(BufferedReader br) throws IOException{
        String[][] input = new String[N][9];
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine().split(" ");
        }

        for (int i = 0; i < 9; i++) {
            ArrayList<Integer> result = new ArrayList<>(); // 각 선수 이닝 결과
            for (int j = 0; j < N; j++) {
                result.add(Integer.parseInt(input[j][i]));
            }
            playerRecord.put(i,result);
        }

    }
}
