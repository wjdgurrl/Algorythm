package programmers;

import java.util.*;

public class course_42889 {
    public static void main(String[] args) {
        Failure fal = new Failure();
        System.out.println(Arrays.toString(fal.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(fal.solution(4,new int[]{4,4,4,4,4})));
        System.out.println(Arrays.toString(fal.solution(3,new int[]{1,1,1})));
    }

}
class Failure{
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[][] map = new double[N][2];
        double failure;
        int num=0;
        int stg = 1;
        int t=0;
        Arrays.sort(stages);
        int player = stages.length;
        while(t!= N){
            for (int i = 0; i < stages.length; i++) {
                if(stages[i] == stg) num++;
            }
            if(num == 0){
                map[t][0] = stg;
                map[t][1] = 0;
                num = 0;
                stg ++;
                t++;
                continue;
            }
            failure = (double) num/player;
            map[t][0] = stg;
            map[t][1] = failure;
            player -= num;
            num = 0;
            stg ++;
            t++;
        }
        for (int j = 0; j < N-1; j++) {
            for (int k = j+1; k < N; k++) {
                if(map[j][1] < map[k][1]){
                    trans(map,j,k,0);
                    trans(map,j,k,1);
                    continue;
                }
                if(map[j][1] == map[k][1]){
                    if(map[j][0] > map[k][0]) {
                        trans(map,j,k,0);
                        trans(map,j,k,1);
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            answer[i] = (int)map[i][0];
        }
        return answer;
    }
    void trans(double[][] map, int j, int k, int num){
                double temp = map[j][num];
                map[j][num] = map[k][num];
                map[k][num] = temp;
    }
}
