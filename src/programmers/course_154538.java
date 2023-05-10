package programmers;
import java.util.*;
import java.io.*;
public class course_154538 {
    public static void main(String[] args) {
        System.out.println(aaa.solution(10,40,2));
    }
    static ArrayList<Integer> arr = new ArrayList<>();
    static class aaa{
        public static int solution(int x, int y, int n){
            //setarr(y);
            int[] ar = new int[y+1];
            Arrays.fill(ar,-1);
            int num = 1;
            int answer= 0;
            for (int i = y; i == x ; i--) {
                if(ar[y+1]==-1) ar[y+1] += num;
                else{
                    if(i/3>0 && i%3 == 0) ar[i/3] = num;
                    if(i/2 >0 && i%2 == 0) ar[i/2] = num; //0,1,2
                    if(i-n > 0) ar[i-2] = num;
                }
                num++;




            }
            return answer;
        }
        /*private static void setarr(int y){
            for (int i = 0; i < y; i++) {
                arr.add(0);
            }
        }*/
    }
}
