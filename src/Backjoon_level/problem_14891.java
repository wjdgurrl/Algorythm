package Backjoon_level;

import java.util. *;
import java.io. *;

//https://www.acmicpc.net/problem/14891
public class problem_14891 {
    private static ArrayList<Gear> Gears;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Gears = new ArrayList<>();
        int[] gearScore = {1,2,4,8};
        int score = 0;
        for (int i = 0; i < 4; i++) {
            ArrayDeque<Integer> gearState = readGear(br);
            Gear gear = new Gear(gearState,gearScore[i]);
            Gears.add(gear);
        }

        rotate(br);
        score = getScore();
        System.out.println(score);
    }

    private static int getScore(){
        int score = 0;
        for (int i = 0; i < 4; i++) {
            score += Gears.get(i).getScore();
        }
        return score;
    }

    private static void rotate(BufferedReader br)throws IOException{
        int k = Integer.parseInt(br.readLine()); // 돌리는 횟수
        for(int i=0;i<k;i++){
            String[] input = br.readLine().split(" ");
            int gearNum = Integer.parseInt(input[0]) - 1; // 기준 기어
            int rotateDirection = Integer.parseInt(input[1]); //방향

            //기준 기어의 [2],[6]번 검사하기
            //좌 우 검사하기
            int[] magnets = new int[4]; //0,-1,1
            magnets[gearNum] = rotateDirection;

            //좌 검사
            for(int j = gearNum; j > 0; j--){
                int left = Gears.get(j-1).state.toArray(new Integer[0])[2];
                int right = Gears.get(j).state.toArray(new Integer[0])[6];
                //둘이 달라야 반대방향으로 돔
                if(left!=right){
                    magnets[j-1] = -magnets[j];
                }else{
                    break;
                }
            }

            //우 검사
            for(int j = gearNum; j < 3; j++){
                int left = Gears.get(j).state.toArray(new Integer[0])[2];
                int right = Gears.get(j+1).state.toArray(new Integer[0])[6];
                //둘이 달라야 반대방향으로 돔
                if(left!=right){
                    magnets[j+1] = -magnets[j];
                }else{
                    break;
                }
            }

            for (int j = 0; j < 4; j++) {
                if(magnets[j]!=0){
                    Gears.get(j).rotateGear(magnets[j]);
                }
            }

        }
    }

    private static ArrayDeque<Integer> readGear(BufferedReader br)throws IOException{
        String[] line = br.readLine().split("");
        ArrayDeque<Integer> gearState = new ArrayDeque<>();
        for (int i = 0; i < 8; i++) {
            gearState.offerLast(Integer.parseInt(line[i]));
        }
        return gearState;
    }


    private static class Gear{
        private ArrayDeque<Integer> state;
        private int score;

        private Gear(ArrayDeque<Integer> state,int score){
            this.state = state;
            this.score = score;
        }

        private int getScore(){
            if(this.state.peekFirst() == 1){
                return score;
            }
            return 0;
        }

        //맨 뒤 인덱스가 앞으로
        private void rotateGear(int clockDirection){
            //안돌때
            if(clockDirection == 0){
                return;
            }
            if(!this.state.isEmpty() && clockDirection == 1){
                int temp = this.state.pollLast();
                this.state.offerFirst(temp);
                return;
            }//반시계
            if(!this.state.isEmpty() && clockDirection == -1){
                int temp = this.state.pollFirst();
                this.state.offerLast(temp);
            }
        }

    }
}
