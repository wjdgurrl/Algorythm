package programmers;

import java.util.Arrays;
import java.util.HashSet;

public class course_42862 {
    public static void main(String[] args) {

        System.out.println(solution(5,new int[]{4,5},new int[]{3,4}));
    }
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        int lose = lost.length;
        //n은 전체 학생 수 lost는 잃어버린 학생 번호 배열, reserve는 여벌 체육복을 가져온 학생 수
        for (int i = 0; i < lost.length; i++) {
            int down = lost[i] - 1;
            int up = lost[i] + 1;
            for (int j = 0; j < reserve.length; j++) {
                if(reserve[j] == lost[i]){
                    reserve[j] = 100;
                    lose++;
                    break;
                }
                if(reserve[j] == down){
                    reserve[j] = 100;
                    lose--;
                    break;
                }
                if (reserve[j] == up){
                    reserve[j] = 100;
                    lose--;
                    break;
                }
            }

        }
        answer = n - lose;
        return answer;
    }
}
