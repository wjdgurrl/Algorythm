package programmers;
import java.util.*;
import java.io.*;
public class course_150368 {
    public static void main(String[] args) {
        int[][] users = new int[][]{{40,10000},{25,10000}};
        int[] emotions = new int[]{7000,9000};
        course_150368 cc = new course_150368();
        System.out.println(Arrays.toString(cc.solution(users, emotions)));
    }
    public int[] solution(int[][] users, int[] emoticons){
        int[] answer = {};
        double percent;
        int plusUser  = 0;
        int notplus = 0;
        ArrayList<Integer> money = new ArrayList<>();
        for (int i = 0; i < users.length; i++) {
            int total = 0;
            percent = users[i][0];
            for (int j = 0; j < emoticons.length; j++) {
                money.add((int) (emoticons[j] * (100 - percent) / 100));
                total += money.get(j);
            }
            if (total >= users[i][1]){
                plusUser ++;
            }
            else if(total < users[i][1]){
                for (int j = 0; j < money.size(); j++) {
                    notplus += money.get(j);
                }
            }
            answer = new int[]{plusUser,notplus};
        }


        return answer;
    }
}
