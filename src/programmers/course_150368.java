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
    static int[] sales = new int[]{10,20,30,40};
    static ArrayList<int[]> arr = new ArrayList<>();
    public int[] solution(int[][] users, int[] emoticons){
        int[] answer = {};
        aaa(users,emoticons,0);
        System.out.println(Arrays.toString(arr.get(0)));
        return answer;
    }
    public void aaa(int[][] users, int[] emoticons,int depth){
        if(depth == users.length) return;
        int[] result = new int[users.length]; // {구매비용}

        for (int i = 0; i < users.length; i++) {
            for (int j = 0; j < sales.length; j++) {
                if (users[i][0] <= sales[j]) {
                    int purchase = emoticons[depth] * (100 - users[i][0]) / 100;
                    result[i] = purchase;
                    break;
                }
                if(users[i][0] > sales[j]){
                    result[i] = emoticons[depth];
                }
            }
        }
        arr.add(result);
        aaa(users, emoticons, ++depth);
    }
}
