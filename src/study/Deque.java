package study;
import java.util.*;
public class Deque {
    public static void main(String[] args) {
        Deque dq = new Deque();
        System.out.println(dq.solution(new int[]{3,2,4,1,3},new boolean[]{true,false,true,false,false}));
    }
    public int[] solution(int[] arr, boolean[] flag) {
        int[] answer = {};
        java.util.Deque<Integer> deque = new LinkedList<>();
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
