package Backjoon_level;
import java.util.*;
import java.io.*;
public class problem_1152 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> arr = new ArrayList<>();
        StringTokenizer st;
        String input = br.readLine();
        st = new StringTokenizer(input);
        while(st.hasMoreTokens()){
            arr.add(st.nextToken());
        }
        System.out.println(arr.size());


    }
}
