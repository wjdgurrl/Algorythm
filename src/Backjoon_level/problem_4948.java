package Backjoon_level;
import java.io.*;
import java.util.*;
public class problem_4948 {
    static ArrayList<Integer> result = new ArrayList<>();
    static ArrayList<Integer> result2 = new ArrayList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();

        int a = 1;
        while(a != 0){
            a = Integer.parseInt(br.readLine());
            arr.add(a);
        }
        System.out.println(d(arr));
    }
    static ArrayList<Integer> d(ArrayList<Integer> arr){
        for (int i = 0; i < arr.size()-1; i++) {
            int n = arr.get(i);
            int count=0;

            for (int j = n+1; j <= 2*n; j++) {
                if(n==1){
                    count++;
                    break;
                }
                if(j%2 !=0 && (j%3 !=0 ||j/3==1) && (j%5 !=0 ||j/5==1) && (j%7 !=0 ||j/7==1)){
                    count ++;
                }
            }
            result2.add(count);
            count = 0;
                //1 ,3 ,5, 7, 11 ,13, 17, 19, 23, 29, 31, 33, 37, 41, 43, 47, 51, 53, 59, 61, 67, 71, 79 ,83, 91, 97*/
        }
        return result2;
    }
}
