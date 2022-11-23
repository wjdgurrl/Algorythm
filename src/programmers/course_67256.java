package programmers;

import java.lang.reflect.Array;
import java.util.Arrays;

public class course_67256 {
    public static void main(String[] args) {
        Keypad key = new Keypad();
        System.out.println(key.keypad(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},"right"));
    }
}
class Keypad{
    public String keypad(int[] numbers, String hand){
        String answer="";
        String usehand="";
        int leftState = 10;
        int rightState = 12;

        int rightdistance = 0;
        int leftdistance = 0;

        /*int[] left = {1,4,7};
        int[] right ={3,6,9};
        int[] center = {2,5,8,11};*/

       /* int[][] arr = new int[4][3];
        for (int i = 0; i < 4; i++) {
            Arrays.fill(arr[i],-1);
        }*/

        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 0){
                numbers[i] = 11;
            }
            if(numbers[i]%3 ==1){
                leftState = i;
                usehand = "L";
                answer = answer + usehand ;
            }else if(numbers[i]%3 ==0 && numbers[i]!=0) {
                rightState = i;
                usehand = "R";
                answer = answer + usehand;
            }else if (numbers[i]%3 ==2 || numbers[i] == 11){
                rightdistance = Math.abs((rightState)-2 - numbers[i]);
                leftdistance = Math.abs(leftState - numbers[i]);


                if (rightdistance == leftdistance){
                    if(hand.equals("right")){
                        rightState = i;
                        usehand = "R";
                        answer = answer + usehand;
                    }
                    else if(hand.equals("left")){
                        leftState = i;
                        usehand = "L";
                        answer = answer + usehand;
                    }
                }else if(rightdistance>leftdistance){
                        leftState = i;
                        usehand = "L";
                        answer = answer + usehand ;
                }else if(leftdistance>rightdistance){
                        rightState = i;
                        usehand = "R";
                        answer = answer + usehand ;
                }
            }
        }
        return answer;
    }
}
