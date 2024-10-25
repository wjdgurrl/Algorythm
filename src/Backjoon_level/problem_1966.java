package Backjoon_level;
import java.util.*;
import java.io.*;
public class problem_1966 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int answer = 0;
            ProcessQueue processQueue = new ProcessQueue();
            String[] fisrtInput  = (br.readLine().split(" "));
            int N = Integer.parseInt(fisrtInput[0]);//문서 개수
            int M = Integer.parseInt(fisrtInput[1]);//찾아야 하는 index
            String[] secondInput = br.readLine().split(" ");
            for (int j = 0; j < secondInput.length; j++) {
                processQueue.addProcess(new Process(j,M));
            }
            while(!processQueue.isEmpty()){
                Process CurrentProcess = processQueue.nextQueue();
                if(processQueue.hasHigherPriority(CurrentProcess)){
                    processQueue.addProcess(CurrentProcess);
                }else{
                    answer++;
                    if(CurrentProcess.getIndex() == M){
                        System.out.println(answer);
                    }
                }
            }

        }
    }
    private static class Process{
        private final int index;
        private final int priority;

        private Process(int index,int priority){
            this.index = index;
            this.priority = priority;
        }

        public int getIndex() {
            return index;
        }
        public int getPriority(){
            return priority;
        }
    }

    private static class ProcessQueue{
        final Deque<Process> deque = new LinkedList<>();

        public void addProcess(Process process){
            deque.offerLast(process);
        }

        public boolean hasHigherPriority(Process process){
            for (Process p : deque){
                if(p.getPriority() > process.getPriority()){
                    return true;
                }
            }
            return false;
        }

        public Process nextQueue(){
            return deque.pollFirst();
        }

        public boolean isEmpty(){
            return deque.isEmpty();
        }

    }
}
