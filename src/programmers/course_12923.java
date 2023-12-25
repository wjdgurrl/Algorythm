package programmers;

import java.util.*;
import java.io.*;

public class course_12923 {
    static int[] answer = {};
    static int IDX = 0;
    public static void main(String[] args) {
        course_12923 aa = new course_12923();
        System.out.println(aa.solution(1, 10));
        //System.out.println(aa.solution(3,5));
    }

    public int[] solution(long begin, long end) {
        answer = new int[(int) (end - begin + 1)];

            /*for (int i = (int)end; i >= begin; i--) {
                primeNum(i,i/2,(end-begin));
            }*/
        int index = 0;
        for (int i = (int) begin; i <= end; i++) {
            answer[index++] = primeNum2(i);
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
        /*private void primeNum(long num,long index,long arr_index){
            if(num == 1){
                answer[0] = 0;
                return;
            }
            //10,000,000
            if (num % (index) == 0){
                if(num / index <= 10000000){
                    answer[(int) (arr_index - IDX)] = (int) index;
                    IDX++;
                    index = -1;
                }
            }
            if(index == -1){
                return;
            }
            primeNum(num,index - 1,arr_index);
    }*/
    private int primeNum2(int num){
        //num<=10,000,000
        if (num == 1){
            return 0;
        }
        int max = 1;
        for (int i = 2; i >= 0; i--) {
            if(num % i == 0){
                return i;
            }
        }
        return max;
    }
}
