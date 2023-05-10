package programmers_level0;
import java.net.InterfaceAddress;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;
public class courser_140108 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Moonja div = new Moonja();
        System.out.println(div.set_s(s));
    }



}

class Moonja {
    public int set_s(String s) {
        int answer = 0;
        char x = (s.charAt(0)); // 맨 앞글자
        int x_count=1;
        int n_count=0;

        //abracadabra
        for (int i = 1; i < s.length(); i++) {
            if(x==' '){
                x = s.charAt(i);
                continue;
            }
            if (x == s.charAt(i)){
                x_count++;
            }
            else{
                n_count++;
            }
            if(x_count == n_count){
                answer ++;
                x = ' ';
                x_count = 1;
                n_count = 0;
            }

        }
        if(x != ' '){
            answer++;
        }

        return answer;
    }
}

