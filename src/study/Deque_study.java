package study;

import java.util.*;

public class Deque_study {
    public static void main(String[] args) throws InterruptedException {
        Deque_study aa = new Deque_study();
        System.out.println(Arrays.toString(aa.solution(new int[]{0, 1, 0, 0})));
    }
    public int[] solution(int[] arr) throws InterruptedException{
        int[] answer = {};
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        int i = 0;
        while(i < arr.length){
            if(stk.isEmpty()){
                stk.addFirst(arr[i]);
                i++;
                continue;
            }
            if(!stk.isEmpty() && stk.peekFirst() == arr[i]){
                stk.removeFirst();
                i++;
                continue;
            }
            if(!stk.isEmpty() && stk.peekFirst() != arr[i]){
                stk.addFirst(arr[i]);
                i++;
                continue;
            }
        }
        int t= 0;
        if(stk.peekFirst() == null){
            answer = new int[stk.size()+1];
            answer[t] = -1;
        }
        else{
            answer = new int[stk.size()];
            while(!stk.isEmpty()){
                answer[t++] = stk.removeFirst();
            }
        }
        return answer;
    }
}
