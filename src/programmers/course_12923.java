package programmers;

import java.util.*;
import java.io.*;

public class course_12923 {
    static int[] answer = {};
    static int IDX = 0;
    public static void main(String[] args) {
        course_12923 aa = new course_12923();
        System.out.println(aa.solution(100000014, 100000016));
        //System.out.println(aa.solution(3,5));
    }
    public int[] solution(long begin, long end){
        answer = new int[(int) (end-begin+1)];
        for (long i = end; i >= begin; i--) {
            primeNum(i, (i/2),(end-begin));
        }
       /*for (int i = (int)begin; i<= end;i++){
            answer[t++] = primeNum2(i);
        }*/
        System.out.println(Arrays.toString(answer));
        return answer;
    }
    private void primeNum(long num,long index,long arr_index){
        if(num == 1){
            answer[0] = 0;
            return;
        }
        if (num % (index) == 0){
            answer[(int) (arr_index - IDX)] = (int) index;
            IDX++;
            index = -1;
        }
        if(index == -1){
            return;
        }
        primeNum(num,index - 1,arr_index);
    }
    private int primeNum2(int num){
        if(num == 1){
            return 0;
        }
        for (int i = 2; i<= Math.sqrt(num);i++){
            //1,2,3,4,5 1 4 9 16 25  1<=5
            if(num % i == 0){
                return i;
            }
        }
        return 1;
    }
}
