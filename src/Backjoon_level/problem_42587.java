package Backjoon_level;
import java.util.*;
import java.io.*;
public class problem_42587 {
    public static void main(String[] args) {
        problem_42587 aa = new problem_42587();
        System.out.println(aa.solution(new int[]{2,1,3,2},2));
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        ProcessQueue processQueue = new ProcessQueue();
        for (int i = 0; i < priorities.length; i++) {
            processQueue.addProcess(new Process(i, priorities[i]));
        }

        while(!processQueue.isEmpty()){
            Process currentProcess = processQueue.nextProcess();
            if(processQueue.HigherPriority(currentProcess)){
                processQueue.addProcess(currentProcess); //우선순위 검사
            }else{
                answer ++;
                if(currentProcess.getIndex() == location) return answer;
            }
        }

        return answer;
    }
    static class Process{
        private final int index;
        private final int priority;

        public Process(int index,int priority){
            this.index = index;
            this.priority = priority;
        }

        public int getIndex(){
            return index;
        }

        public int getPriority(){
            return priority;
        }
    }

    static class ProcessQueue{
        private final Deque<Process> deque = new LinkedList<>();

        public void addProcess(Process process){
            deque.offerLast(process);
        }

        public Process nextProcess(){
            return deque.pollFirst();
        }

        public boolean HigherPriority(Process process){
            for(Process p : deque){
                if(p.getPriority() > process.getPriority()){
                    return true;
                }
            }
            return false;
        }

        public boolean isEmpty(){
            return deque.isEmpty();
        }
    }
}

