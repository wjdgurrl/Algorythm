package Backjoon_level;

import java.io.*;

public class problem_2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader((System.in))));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n*2-1; i++) {
            for (int j = 0; j < n*2-1; j++) {
                if (n <= i) { //하단
                    if (i - n + 1 <= j && j <= 3*n - i - 3) {
                        System.out.print("*");
                    } else{
                        if(2*n-n<= j){
                            break;
                        }
                        System.out.print(" ");
                    }
                } else {
                    if ((n - 1) - i <= j && j < n + i) {
                        System.out.print("*");
                    } else{
                        if(j  >= n-1){
                            break;
                        }
                        System.out.print(" ");
                    }
                }
            }
            if(i < 2*n-2)System.out.println();
        }
    }
}
//else if(2*n-1 <= j)
//else if(j  >= n + 1)
