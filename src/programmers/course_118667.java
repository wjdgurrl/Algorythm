package programmers;
import java.util.*;
import java.io.*;
public class course_118667 {
    public static void main(String[] args) {
        course_118667 aa = new course_118667();
        System.out.println(aa.solution(new int[]{3,2,7,2},new int[]{4,6,5,1}));
        //2/2 = 1
    }
    Queue<Long> q1 = new LinkedList<>();
    Queue<Long> q2 = new LinkedList<>();
    long q1total = 0;
    long q2total = 0;
    public int solution(int[] queue1, int[] queue2){
        int answer = 0;
        long e = (queue1.length + queue2.length)* 2L;
        q1total = val_add(queue1,q1);
        q2total = val_add(queue2,q2);
        if((q1total+q2total)%2 == 0){
            while(q1total != q2total){
                if(q1total>q2total){
                    long num = q1.poll();
                    q2.offer(num);
                    q2total += num;
                    q1total -= num;
                }
                else{
                    long num = q2.poll();
                    q1.offer(num);
                    q1total += num;
                    q2total -= num;
                }
                answer++;
                if(answer > e){
                    return -1;
                }
            }
        }
        else return -1;

        return answer;
    }
    long val_add(int[] queue,Queue<Long> q){
        long qtotal = 0;
        for (int i = 0; i < queue.length; i++) {
            long num = queue[i];
            q.offer(num);
            qtotal += num;
        }
        return qtotal;
    }
}
