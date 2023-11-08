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
    ArrayList<int[]> list = new ArrayList<>();
    public int[] solution(int[][] users, int[] emoticons){
        int[] answer = {};
         //최종 배열
        for (int i = 10; i <= 40 ; i+=10) {
            int[] total = new int[users.length];
            PlusUser(total, users, emoticons,i,0);
        }
        return answer;
    }
    public void PlusUser(int[] total, int[][] users, int[] emoticons,int discount, int depth){
        if(depth == emoticons.length) return;
        int[] discount_emoticons = total.clone();
        for (int i = 0; i < users.length; i++) {
            if(users[i][0] <= discount){
                continue;
            }
            else{
                discount_emoticons[i] += emoticons[depth] * (100 - discount) / 100 ;
            }
        }
        for (int i = 10; i <= 40; i += 10) {
            PlusUser(discount_emoticons, users, emoticons,i,++depth);
        }
        if(depth == emoticons.length-1){
            list.add(discount_emoticons);
        }
    }
}
