package study;
import java.util.*;
public class Dequee {
    public static void main(String[] args) {
        Dequee dq = new Dequee();
        System.out.println(dq.solution(new int[]{3,2,4,1,3},new boolean[]{true,false,true,false,false}));
    }
    public int[] solution(int[] arr, boolean[] flag) {
        int[] answer = {};
        Deque<Integer> deque = new LinkedList<>();
        for(int i =0;i<flag.length;i++){
            int t = 0;
            if(flag[i] == true){
                while(t++ < arr[i] * 2){
                    deque.offerLast(arr[i]);
                }
            }else{
                while(t++ < arr[i]){
                    deque.pollLast();
                }
            }
        }
        answer = new int[deque.size()];
        for(int i = 0; i < deque.size();i++){
            answer[i] = deque.pollFirst();
        }
        return answer;
    }
}
