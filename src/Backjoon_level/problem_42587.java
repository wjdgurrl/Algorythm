package Backjoon_level;
import java.util.*;
import java.io.*;
public class problem_42587 {
    public static void main(String[] args) {

    }
    public int solution(int[] priorities, int location){
        int answer = 0;
        Deque<Integer> waiting_process = new LinkedList<>();
        Deque<Integer> execute_process = new LinkedList<>();
        for (int t : priorities) waiting_process.offerLast(t);
        int cutLine;
        while(location != -1){
            //대기 큐가 비었을 시
            if(waiting_process.isEmpty()){
                waiting_process.offerLast(execute_process.pollFirst());
                cutLine = waiting_process.peekFirst();
                location --;
            }
            //대기 큐가 실행 큐보다 우선순위가 클때
            if(waiting_process.peekFirst() > execute_process.peekFirst()){
                execute_process.offerFirst(waiting_process.pollFirst());
            }
        }
        return answer;
    }
}
