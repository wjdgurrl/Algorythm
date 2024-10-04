package programmers;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/12907
public class course_12907 {
    public static void main(String[] args) {
        course_12907 aa = new course_12907();
        System.out.println(aa.solution(5,new int[]{1,2,5}));
    }
//        0
//        1	    1
//        2	    11		    2
//        3	    111		    12
//        4	    1111		112		    22
//        5	    11111		1112		122		    5
//        6	    111111		11112		1122		222	    5
//        7	    1111111		111112		11122		1222	115	    25
//        8	    11111111	1111112		111122		11222	2222	1115	125
//        9	    111111111	11111112	1111122		111222	12222	11115	1125	225
//        10	1111111111	111111112	11111122	1111222	112222	111115	11125	1225	22222	55

//    0   0     1   2   3   4   5   6   7   8   9   10
//    0   0     0   0   0   0   0   0   0   0   0   0
//    1   0     1   1   1   1   1   1   1   1   1   1
//    2   0     1   2   2   3   3   3   4   4   5   5
//    5   0     1   2   2   3   4   5   6   7   8   10

    public int solution(int n, int[] money) {
        int answer = 0;
        Arrays.sort(money);
        int[][] arr = new int[money.length+1][n+1];
        for (int i = 1; i < money.length+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if(j == 0){
                    arr[i][j] = 1;
                }else{
                    if(j >= money[i-1]){
                        arr[i][j] = arr[i-1][j] + arr[i][j-money[i-1]];
                    }
                    else{
                        arr[i][j] = arr[i-1][j];
                    }
                }
            }
        }
        answer = arr[money.length][n];
        return answer % 1000000007;
    }
}
