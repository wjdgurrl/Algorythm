package Backjoon_level;

import java.util.*;
import java.io.*;

public class problem_10845 {
    final static Deque<Integer> deque = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String[] command = br.readLine().split(" ");
            switch (command[0]){
                case "push" :
                    deque.add(Integer.parseInt(command[1])); // 큐의 push
                    break;
                case "pop" :
                    System.out.println(deque.isEmpty()?-1:deque.removeFirst()); // 큐의 poll
                    break;
                case "size" :
                    System.out.println(deque.size());
                    break;
                case "empty" :
                    System.out.println(deque.isEmpty()?1:0);
                    break;
                case "front" :
                    System.out.println(deque.isEmpty()?-1:deque.getFirst());
                    break;
                case "back" :
                    System.out.println(deque.isEmpty()?-1:deque.getLast());
                    break;

            }

        }
    }
}
